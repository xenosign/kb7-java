package collection.list;

import java.util.*;

public class ListPerformanceTest {
    static final int SIZE = 100_000;

    public static void main(String[] args) {
        List<Integer> arrayList  = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        
        // List 세팅
        for (int i = 0; i < SIZE; i++) arrayList.add(i);
        for (int i = 0; i < SIZE; i++) linkedList.add(i);

        // 추가 케이스
        // ArrayList 중간에 추가
        long startTime = System.nanoTime();
        arrayList.add(SIZE/2, 1);
        long endTime = System.nanoTime();
        System.out.println("ArrayList 중간 추가: " + (endTime - startTime));

        // LinkedList 중간에 추가
        startTime = System.nanoTime();
        linkedList.add(SIZE/2, 1);
        endTime = System.nanoTime();
        System.out.println("LinkedList 중간 추가: " + (endTime - startTime));

        // ArrayList 제일 앞에 추가
        startTime = System.nanoTime();
        arrayList.add(0, 1);
        endTime = System.nanoTime();
        System.out.println("ArrayList 맨 앞 추가: " + (endTime - startTime));

        // LinkedList 제일 앞에 추가
        startTime = System.nanoTime();
        linkedList.add(0, 1);
        endTime = System.nanoTime();
        System.out.println("LinkedList 맨 앞 추가: " + (endTime - startTime));

        // ArrayList 중간 조회
        startTime = System.nanoTime();
        arrayList.get(SIZE / 2);
        endTime = System.nanoTime();
        System.out.println("ArrayList  중간 조회: " + (endTime - startTime));

        // LinkedList 중간 조회
        startTime = System.nanoTime();
        linkedList.get(SIZE / 2);
        endTime = System.nanoTime();
        System.out.println("LinkedList 중간 조회: " + (endTime - startTime));

    }
}