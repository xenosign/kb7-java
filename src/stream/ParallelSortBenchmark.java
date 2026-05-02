package stream;

import java.util.stream.LongStream;

public class ParallelSortBenchmark {
    public static void main(String[] args) {
        long dataSize = 10_000_000L;

        System.out.println("=== parallel() + 정렬 성능 벤치마크 ===");
        System.out.printf("데이터 크기: %,d개%n", dataSize);
        System.out.printf("ForkJoinPool parallelism: %d%n%n",
                java.util.concurrent.ForkJoinPool.commonPool().getParallelism());

        warmUp(dataSize);

        System.out.println("=== sorted() 유무에 따른 parallel 효과 비교 ===\n");

        // ─── 1. 정렬 없음 ───────────────────────────────────────────
        benchmarkSum("단순 합산 (no sort) - seq ", dataSize, false, false);
        benchmarkSum("단순 합산 (no sort) - par ", dataSize, true,  false);
        System.out.println();

        // ─── 2. 정렬 있음 ───────────────────────────────────────────
        // parallel + sorted() → 내부적으로 전체 merge-sort 필요
        //   - 각 스레드가 부분 정렬 → 최종 병합 단계에서 순차 병목
        benchmarkSum("단순 합산 (sorted)  - seq ", dataSize, false, true);
        benchmarkSum("단순 합산 (sorted)  - par ", dataSize, true,  true);
        System.out.println();

        // ─── 3. Math.sqrt 연산 + 정렬 ──────────────────────────────
        benchmarkSqrt("sqrt 합산  (no sort) - seq", dataSize, false, false);
        benchmarkSqrt("sqrt 합산  (no sort) - par", dataSize, true,  false);
        System.out.println();
        benchmarkSqrt("sqrt 합산  (sorted)  - seq", dataSize, false, true);
        benchmarkSqrt("sqrt 합산  (sorted)  - par", dataSize, true,  true);
        System.out.println();

        // ─── 4. findFirst() : 정렬 병렬에서 순차와 차이 없어지는 케이스 ──
        // parallel + sorted + findFirst → 전체 정렬 완료 후 첫 요소 반환
        benchmarkFindFirst("findFirst (no sort) - seq", dataSize, false, false);
        benchmarkFindFirst("findFirst (no sort) - par", dataSize, true,  false);
        System.out.println();
        benchmarkFindFirst("findFirst (sorted)  - seq", dataSize, false, true);
        benchmarkFindFirst("findFirst (sorted)  - par", dataSize, true,  true);
    }

    // ─── sum 벤치마크 ─────────────────────────────────────────────────
    static void benchmarkSum(String label, long size, boolean parallel, boolean sorted) {
        long start = System.currentTimeMillis();

        LongStream stream = LongStream.range(0, size);
        if (parallel) stream = stream.parallel();
        if (sorted)   stream = stream.sorted();   // ← 핵심: 정렬이 병렬 이점을 죽임
        double result = stream.mapToDouble(i -> i).sum();

        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("%-30s | %4d ms | result=%.0f%n", label, elapsed, result);
    }

    // ─── sqrt 벤치마크 ────────────────────────────────────────────────
    static void benchmarkSqrt(String label, long size, boolean parallel, boolean sorted) {
        long start = System.currentTimeMillis();

        LongStream stream = LongStream.range(0, size);
        if (parallel) stream = stream.parallel();
        if (sorted)   stream = stream.sorted();
        double result = stream.mapToDouble(Math::sqrt).sum();

        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("%-30s | %4d ms | result=%.2f%n", label, elapsed, result);
    }

    // ─── findFirst 벤치마크 ───────────────────────────────────────────
    // sorted + findFirst 조합: parallel이어도 전체 정렬 완료 전엔 첫 요소 못 냄
    static void benchmarkFindFirst(String label, long size, boolean parallel, boolean sorted) {
        long start = System.currentTimeMillis();

        LongStream stream = LongStream.range(0, size);
        if (parallel) stream = stream.parallel();
        if (sorted)   stream = stream.sorted();
        long result = stream.filter(i -> i % 3 == 0).findFirst().orElse(-1);

        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("%-30s | %4d ms | result=%d%n", label, elapsed, result);
    }

    static void warmUp(long dataSize) {
        System.out.println("[워밍업 중...]");
        long wSize = dataSize / 10;
        LongStream.range(0, wSize).mapToDouble(Math::sqrt).sum();
        LongStream.range(0, wSize).parallel().mapToDouble(Math::sqrt).sum();
        LongStream.range(0, wSize).sorted().mapToDouble(i -> i).sum();
        LongStream.range(0, wSize).parallel().sorted().mapToDouble(i -> i).sum();
        System.out.println("[워밍업 완료]\n");
    }
}
