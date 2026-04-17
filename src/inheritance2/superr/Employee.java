package inheritance2.superr;

class Employee {
    public String name = "직원 클래스";
    public int salary = 3000000;

    public Employee() {
        System.out.println("빈 생성자를 추가!");
    }

    public Employee(String name, int salary) {
        System.out.println("Employee 생성자");
        this.name = name;
        this.salary = salary;
    }

    public void goToWork() {
        System.out.println(this.name + " 출근 합니다!");
    }
    public void getSalary() {
        System.out.println(this.name + "은 월급으로 " + this.salary + " 를 받습니다");
    }
}
