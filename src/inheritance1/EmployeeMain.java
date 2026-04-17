package inheritance1;

public class EmployeeMain {
    public static void main(String[] args) {
        Intern janggre = new Intern();

        janggre.goToWork();
        janggre.getSalary();
        janggre.threeMonthLater();

        Manager kimdaeri = new Manager();

        kimdaeri.goToWork();
        kimdaeri.getSalary();
        kimdaeri.oneYearLater();
    }
}
