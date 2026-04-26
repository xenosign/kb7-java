package exception.check;

// Exception 을 상속 받으면 Check 예외가 된다
public class MyCheckException extends Exception {
    public MyCheckException(String message) {
        super(message);
    }
}
