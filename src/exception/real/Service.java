package exception.real;

import exception.real.exceptions.MyCheckException;
import exception.real.exceptions.MyUncheckException;

public class Service {
    public static void main(String[] args) {
        Repository repository = new Repository();

        try {
            repository.callException();
            repository.callException2();
        } catch (Exception e) {
            // 모든 예외를 처리하는 메서드를 만들자!
            e.printStackTrace();
        }

        System.out.println("막았는가?");
    }

    public static void exceptionHandler(Exception e) {
        System.out.println("시스템 : 죄송합니다. 알 수 없는 문제가 발생 했습니다.");
        System.out.println("=== 개발자를 위한 로그 ===");
        
        // 에러 타입에 따라 다르게 처리
        if (e instanceof MyCheckException) {
            System.out.println("MyCheckException 에서 발생한 예외 처리");
            System.out.println("Repository 연결에 문제가 발생");
            MyCheckException exception = (MyCheckException) e;
            exception.printStackTrace();
        } else if (e instanceof MyUncheckException) {
            System.out.println("MyUncheckException 에 대한 예외 처리");
            System.out.println("DB 데이터 변환에 문제가 발생");
            MyUncheckException exception = (MyUncheckException) e;
            exception.printStackTrace();
        }
    }
}
