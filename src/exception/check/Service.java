package exception.check;

public class Service {
    public static void main(String[] args) {
        Repository repository = new Repository();
        try {
            repository.callCheckException();
        } catch (MyCheckException e) {
            e.printStackTrace();
        }

        System.out.println("막았는가!?");
    }
}
