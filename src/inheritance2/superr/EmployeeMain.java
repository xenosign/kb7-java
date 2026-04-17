package inheritance2.superr;

public class EmployeeMain {
    public static void main(String[] args) {
        Manager ohgwajang = new Manager("오과장", 2000000, 1000000);
        ohgwajang.goToWork();
        ohgwajang.getSalary();
        ohgwajang.oneYearLater();
    }
}
