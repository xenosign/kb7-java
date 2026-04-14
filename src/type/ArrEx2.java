package type;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrEx2 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        int sum = 0;
        float avg = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100);
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        avg = (float) sum / nums.length;

        System.out.println("랜덤 배열 : " + Arrays.toString(nums));
        System.out.println("배열의 합산 값 : " + sum);
        System.out.println("배열의 평균 값 : " + avg);
    }
}
