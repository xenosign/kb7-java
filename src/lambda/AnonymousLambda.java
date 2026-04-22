package lambda;

interface MathOperation {
    public int opration(int a, int b);
}

public class AnonymousLambda {
    public static void main(String[] args) {
        MathOperation addition = new MathOperation() {
            @Override
            public int opration(int a, int b) {
                return a + b;
            }
        };
        System.out.println("익명 클래스를 사용한, a + b = " + addition.opration(10, 20));

        MathOperation subtraction = (a, b) -> a - b;
        System.out.println("람다를 사용한, a - b = " + subtraction.opration(10, 5));
    }
}
