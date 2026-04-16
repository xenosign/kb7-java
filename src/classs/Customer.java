package classs;

public class Customer {
    String name;
    int age;
    int total;
    boolean isBlacklist;

    Customer() {
        this.name = "아직 몰라요";
        this.age = 0;
        this.total = 0;
        this.isBlacklist = false;
    }

    Customer(String name, int age, int total) {
        this.name = name;
        this.age = age;
        this.total = total;
        this.isBlacklist = false;
    }

    void printCustomerInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.total);
        System.out.println(this.isBlacklist);
    }
}
