package lambda2;

import java.util.function.Consumer;

public class LambdaConsumer {
    public static void main(String[] args) {
        Consumer<String> cons = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Consumer 익명 클래스로 전달 받은 " + s);
            }
        };
        cons.accept("내일은 놉니다!!!!!");

        Consumer<String> cons2 = (s) -> System.out.println("Consumer 람다로 전달 받은 " + s);
        cons.accept("다음주 화요일까지 놉니다!!!!!");

        Consumer<String> cons3 = System.out::println;
        cons3.accept("전 다다음주 부터 휴가입니다!!!!");
    }
}
