package stream;

import java.util.Arrays;
import java.util.Random;

public class LimitParallel {
    static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        long start, end;
        long[] data = new Random()
                .longs(SIZE, 0, Long.MAX_VALUE)
                .toArray();
        long[] arr1 = Arrays.copyOf(data, data.length);
        long[] arr2 = Arrays.copyOf(data, data.length);

        start = System.currentTimeMillis();
        Arrays.stream(arr1).sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("stream   시간 : " + (end - start) + "ms");

        start = System.currentTimeMillis();
        Arrays.stream(arr2).parallel().sorted().toArray();
        end = System.currentTimeMillis();
        System.out.println("parallel 시간 : " + (end - start) + "ms");
    }
}