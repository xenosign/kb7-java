package lambda2;

import java.util.ArrayList;
import java.util.List;

public class LambdaRunnable {
    public static void main(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        Runnable run2 = () -> System.out.println("hello");

        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        System.out.println(list);
        Runnable run3 = list::clear;
        run3.run();
        System.out.println(list);
    }
}
