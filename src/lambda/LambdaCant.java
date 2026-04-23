package lambda;

interface MathOperation {
    int add(int a, int b);
    int sub(int a, int b);
    double div(int a, int b);
}

interface MathAdd {
    int add(int a, int b);
}

interface MathSub {
    int sub(int a, int b);
}

interface MathDiv {
    double mul(int a, int b);
}

public class LambdaCant {
    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
            @Override
            public int sub(int a, int b) {
                return a - b;
            }
            @Override
            public double div(int a, int b) { return (double) a / b; }
        };

        System.out.println("익명 클래스는 인터페이스 하나로 메서드 2개 가능 하지롱 ^0^, a + b = " + mathOperation.add(10, 20));
        System.out.println("익명 클래스는 인터페이스 하나로 메서드 2개 가능 하지롱 ^0^, a - b = " + mathOperation.sub(10, 20));

        MathAdd mathAdd = (a, b) -> a + b;
        MathSub mathSub = (a, b) -> a - b;
        MathDiv mathDiv = (a, b) -> (double) a / b;

        System.out.println("람다는 메서드 하나만 가능해서 인터페이스 2개 써야함 T_T, a + b = " + mathAdd.add(10, 20));
        System.out.println("람다는 메서드 하나만 가능해서 인터페이스 2개 써야함 T_T, a - b = " + mathSub.sub(10, 20));
    }
}
