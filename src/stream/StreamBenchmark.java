package stream;

import java.util.stream.LongStream;

public class StreamBenchmark {
    public static void main(String[] args) {
        long dataSize = 10_000_000L;

        System.out.println("=== Stream 성능 벤치마크 ===");
        System.out.printf("데이터 크기: %,d개%n", dataSize);
        System.out.printf("ForkJoinPool parallelism: %d%n%n",
                java.util.concurrent.ForkJoinPool.commonPool().getParallelism());

        // 워밍업 (JIT 컴파일러 최적화 유도)
        warmUp(dataSize);

        // Sequential
        long seqStart = System.currentTimeMillis();
        double seqResult = LongStream.range(0, dataSize)
                .mapToDouble(Math::sqrt)
                .sum();
        long seqTime = System.currentTimeMillis() - seqStart;

        // Parallel
        long parStart = System.currentTimeMillis();
        double parResult = LongStream.range(0, dataSize)
                .parallel()
                .mapToDouble(Math::sqrt)
                .sum();
        long parTime = System.currentTimeMillis() - parStart;

        System.out.printf("[Sequential] 결과: %.2f / 시간: %d ms%n", seqResult, seqTime);
        System.out.printf("[Parallel  ] 결과: %.2f / 시간: %d ms%n", parResult, parTime);
        System.out.printf("[Speedup   ] %.2fx 빠름%n", (double) seqTime / parTime);

        System.out.println("\n=== 작업 유형별 비교 ===");
        benchmark("단순 합산    ", dataSize, false,
                i -> (double) i);
        benchmark("Math.sqrt   ", dataSize, false,
                Math::sqrt);
        benchmark("필터 + 제곱  ", dataSize, false,
                i -> i % 2 == 0 ? i * i : 0);
    }

    static void benchmark(String label, long size, boolean parallel,
                          java.util.function.LongToDoubleFunction fn) {
        // sequential
        long s1 = System.currentTimeMillis();
        LongStream.range(0, size).mapToDouble(fn).sum();
        long seqMs = System.currentTimeMillis() - s1;

        // parallel
        long s2 = System.currentTimeMillis();
        LongStream.range(0, size).parallel().mapToDouble(fn).sum();
        long parMs = System.currentTimeMillis() - s2;

        System.out.printf("%s | seq: %4d ms | par: %4d ms | speedup: %.2fx%n",
                label, seqMs, parMs, (double) seqMs / parMs);
    }

    static void warmUp(long dataSize) {
        System.out.println("[워밍업 중...]");
        LongStream.range(0, dataSize / 10).mapToDouble(Math::sqrt).sum();
        LongStream.range(0, dataSize / 10).parallel().mapToDouble(Math::sqrt).sum();
        System.out.println("[워밍업 완료]");
    }
}
