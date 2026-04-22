package lambda;

interface Clickable {
    void click();
}

public class LambdaCant2 {
    public static void main(String[] args) {
        Clickable counter = new Clickable() {
            private int count = 0;

            @Override
            public void click() {
                count++;
                System.out.println("클릭 횟수: " + count);
            }
        };

        counter.click();
        counter.click();
        counter.click();

        int count = 0;
        Clickable lambdaCounter = () -> {
            // 람다는 외부 변수를 캡처할 때 "복사"해서 가져옴
            // count가 나중에 바뀌면 람다 내부의 count와 달라져서 불일치 발생, effectively final 위반
            // count++;
            System.out.println("클릭 횟수: " + count);
        };

        lambdaCounter.click();
        lambdaCounter.click();
        lambdaCounter.click();

        int[] count2 = {0};

        Clickable lambdaCounter2 = () -> {
            count2[0]++;
            System.out.println("클릭 횟수: " + count2[0]);
        };

        lambdaCounter2.click();
        lambdaCounter2.click();
        lambdaCounter2.click();
    }
}
