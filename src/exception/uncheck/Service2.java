package exception.uncheck;

public class Service2 {
    public static void main(String[] args) {
        Repository repository = new Repository();

        try {
            repository.callException();
            repository.callException2();
        } catch (MyUncheckException | MyCheckException e) {
            e.printStackTrace();
        }

        System.out.println("막았는가?");

    }
}
