package exception.real;

import exception.real.exceptions.MyCheckException;
import exception.real.exceptions.MyUncheckException;

public class Service {
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.callException();
            client.callException2();
        } catch (Exception e) {
            // 모든 예외를 처리하는 메서드를 만들자
            exceptionHandler(e);
        }
    }

    public static void exceptionHandler(Exception e) {
        if (e instanceof MyCheckException) {
            System.out.println("MyCheckException 에 대한 예외 처리");
            MyCheckException exception = (MyCheckException) e;
            e.printStackTrace();
            System.out.println("MyCheckException 이 제공하는 메서드 사용");
        } else if (e instanceof MyUncheckException) {
            System.out.println("MyCheckException 에 대한 예외 처리");
            MyUncheckException exception = (MyUncheckException) e;
            e.printStackTrace();
            System.out.println("MyCheckException 이 제공하는 메서드 사용");
        }
    }
}
