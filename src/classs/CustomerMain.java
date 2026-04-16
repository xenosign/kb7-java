package classs;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1 = new Customer("이효석", 41, 1000);
        customer1.printCustomerInfo();

        Customer customer2 = new Customer();
        customer2.printCustomerInfo();
    }
}
