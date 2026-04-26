package exception.uncheck;

public class Client {
    public void callUncheckException() {
        throw new MyUncheckException("Client callUncheckException 에서 발생");
    }
}
