package exception.check;

import java.util.Random;

public class Repository {
    public void callCheckException() throws MyCheckException {
        boolean con = false;
        // DB 관련 통신 작업
        if (!con) throw new MyCheckException("DB 관련 작업에서 MyCheckException 에서 발생");
        // 원하는 작업 수행
    }
    
    public void callRandException() throws MyCheckException2 {
        if (new Random().nextBoolean()) {
            throw new MyCheckException2("오늘은 운이 없으시네요");
        } else {
            System.out.println("오늘은 운이 좋으시군요");
        }
    }
}
