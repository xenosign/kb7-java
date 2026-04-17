package inheritance2.superr;

class Intern extends Employee {
    public String name = "인턴 클래스";
    public int salary = 2000000;

    public Intern(String name, int salary) {
        super();
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void goToWork() {
        System.out.println(this.name + " 인턴이 출근 합니다!");
    }
    @Override
    public void getSalary() {
        int gap = super.salary - this.salary;
        System.out.println(this.name + " 인턴이 기본급 보다 " + gap + "만큼 적은 " + this.salary + " 를 받습니다");
    }
    public void threeMonthLater() {
        System.out.println("이대로 하면 정직원이 되는거죠!?");
    }
}
