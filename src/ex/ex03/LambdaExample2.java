package ex.ex03;

@FunctionalInterface
interface Workable {
    void work();
}

class Person2 {
    public void action(Workable workable) {
        workable.work();
    }
}

public class LambdaExample2 {
    public static void main(String[] args) {
        Person2 person = new Person2();
        //실행문이 두 개 이상인 경우 중괄호 필요
        person.action(() -> {
            System.out.println("출근을 합니다.");
            System.out.println("프로그래밍을 합니다.");
        });

        person.action(() -> System.out.println("퇴근합니다"));
    }
}
