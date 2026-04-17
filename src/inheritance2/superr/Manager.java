package inheritance2.superr;

class Manager extends Employee {
    public String name = "인턴 클래스";
    public int salary = 2000000;
    public int bonus = 1000000;

    public Manager(String name, int salary, int bonus) {
        super();
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
    }
    @Override
    public void goToWork() {
        System.out.println(this.name + " 과장이 출근 합니다!");
    }
    @Override
    public void getSalary() {
        int totalSalary = this.salary + this.bonus;
        System.out.println(this.name + " 과장이 기본급 보다 " + this.bonus + "만큼 많은 " + totalSalary + " 를 받습니다");
    }
    public void oneYearLater() {
        System.out.println("이대로 하면 차장 달 수 있는거죠!?");
    }
}
