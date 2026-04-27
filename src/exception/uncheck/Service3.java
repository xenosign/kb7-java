package exception.uncheck;

public class Service3 {
    public static void main(String[] args) {
        Repository repository = new Repository();

        try {
            repository.callException();
            repository.callException2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("막았는가?");

    }
}
