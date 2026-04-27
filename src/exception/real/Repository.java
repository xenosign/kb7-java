package exception.real;

import exception.real.exceptions.MyCheckException;
import exception.real.exceptions.MyUncheckException;

public class Repository {
    public void callException() {
        boolean con = false;
        // DB 관련 통신 작업
        if (!con) throw new MyUncheckException("DB 관련 작업에서 MyCheckException 발생");
        // 원하는 작업 수행
    }

    public void callException2() throws MyCheckException {
        throw new MyCheckException("DB 관련 작업에서 MyCheckException 발생");
    }
}
