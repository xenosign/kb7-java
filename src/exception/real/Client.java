package exception.real;

import exception.real.exceptions.MyCheckException;
import exception.real.exceptions.MyUncheckException;

public class Client {
    public void callException() {
        throw new MyCheckException("callException 에서 발생");
    }

    public void callException2() {
        throw new MyUncheckException("callException 에서 발생");
    }
}
