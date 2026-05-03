package stream;

import java.util.stream.LongStream;


public class PrimalityTestStream {
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 5_000_000).toArray();

        long start = System.currentTimeMillis();
        long seqCount = java.util.Arrays.stream(numbers)
                .filter(PrimalityTestStream::isPrime)
                .count();
        long seqTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        long parCount = java.util.Arrays.stream(numbers)
                .parallel()
                .filter(PrimalityTestStream::isPrime)
                .count();
        long parTime = System.currentTimeMillis() - start;

        System.out.println("순차: " + seqTime + "ms, 결과: " + seqCount);
        System.out.println("병렬: " + parTime + "ms, 결과: " + parCount);
    }
}
