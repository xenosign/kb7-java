package exception.check;

// Exception 을 상속 받으면 Check 예외가 된다
public class MyCheckException2 extends Exception {
    public MyCheckException2(String message) {
        super(message);
    }
}
