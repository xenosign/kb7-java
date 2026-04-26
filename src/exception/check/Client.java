package exception.check;

import java.util.Random;

public class Client {
    public void callCheckException() throws MyCheckException {
        MyCheckException exception = new MyCheckException("Client callCheckException 에서 발생");
        throw exception;
    }
    
    public void callRandException() throws MyCheckException2 {
        if (new Random().nextBoolean()) {
            throw new MyCheckException2("오늘은 운이 없으시네요");
        } else {
            System.out.println("오늘은 운이 좋으시군요");
        }
    }
}
