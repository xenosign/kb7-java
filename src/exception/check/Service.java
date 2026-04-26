package exception.check;

public class Service {
    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.callCheckException();
            client.callRandException();
        } catch (MyCheckException | MyCheckException2 e) {
            e.printStackTrace();
        }

        System.out.println("막았는가?");
    }
}
