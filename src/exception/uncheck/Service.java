package exception.uncheck;

public class Service {
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.callUncheckException();
        } catch (MyUncheckException e) {
            e.printStackTrace();
        }

        System.out.println("막았는가?");
    }
}
