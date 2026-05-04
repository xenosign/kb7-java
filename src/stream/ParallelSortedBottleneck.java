package stream;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelSortedBottleneck {

    static final int DATA_SIZE = 5_000_000;

    public static void main(String[] args) {
        List<Integer> data = new Random()
                .ints(DATA_SIZE, 0, Integer.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("=== 데이터 크기: " + DATA_SIZE + " ===");
        System.out.println("ForkJoinPool 병렬도: " +
                java.util.concurrent.ForkJoinPool.commonPool().getParallelism());
        System.out.println();

        warmUp(data);

        long t1 = measure(() ->
                data.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * 2)
                        .collect(Collectors.toList())
        );

        long t2 = measure(() ->
                data.parallelStream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * 2)
                        .collect(Collectors.toList())
        );

        long t3 = measure(() ->
                data.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * 2)
                        .sorted()
                        .collect(Collectors.toList())
        );

        long t4 = measure(() ->
                data.parallelStream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * 2)
                        .sorted()
                        .collect(Collectors.toList())
        );

        long t5 = measure(() ->
                data.parallelStream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * 2)
                        .sorted()
                        .limit(1_000_000)
                        .collect(Collectors.toList())
        );

        System.out.printf("① 순차 스트림 (정렬 없음)   : %,d ms%n", t1);
        System.out.printf("② 병렬 스트림 (정렬 없음)   : %,d ms  → 순차 대비 %.1fx%n", t2, (double) t1 / t2);
        System.out.printf("③ 순차 스트림 (sorted 있음) : %,d ms%n", t3);
        System.out.printf("④ 병렬 스트림 (sorted 있음) : %,d ms  → ②대비 %.1fx 느림%n", t4, (double) t4 / t2);
        System.out.printf("⑤ 병렬 스트림 (sorted+limit): %,d ms%n", t5);
        System.out.println();

        // ↓ 수정: t1~t4를 파라미터로 전달
        analyzeResults(t1, t2, t3, t4);
    }

    static long measure(Runnable task) {
        System.gc();
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }

    static void warmUp(List<Integer> data) {
        System.out.println("워밍업 중...");
        for (int i = 0; i < 3; i++) {
            data.parallelStream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
            data.stream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
        }
        System.out.println("워밍업 완료\n");
    }

    // ↓ 수정: 파라미터명을 메서드 내부에서 사용하도록 통일
    static void analyzeResults(long t1, long t2, long t3, long t4) {
        System.out.println("=== 핵심 분석 ===");
        System.out.println("병렬화 효과(정렬 없음): " + (t1 > t2 ? "정상 가속" : "병렬화 오버헤드 역효과"));
        double overhead = ((double) (t4 - t3) / t3) * 100;
        System.out.printf("sorted() 동기화 장벽 오버헤드: +%.1f%%%n", overhead);
        System.out.println();
        System.out.println("원인: sorted()는 내부적으로 Spliterator가 분할했던");
        System.out.println("      모든 청크를 하나의 배열로 합치고(toArray),");
        System.out.println("      Arrays.sort()로 정렬 후 다시 분배.");
        System.out.println("      → 이 순간 모든 워커 스레드가 대기 상태");
    }
}