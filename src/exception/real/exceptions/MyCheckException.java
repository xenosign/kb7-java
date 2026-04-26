package exception.real.exceptions;

// Exception 을 상속 받으면 Check 예외가 된다
public class MyCheckException extends RuntimeException {
    public MyCheckException(String message) {
        super(message);
    }
}
