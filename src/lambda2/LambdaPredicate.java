package lambda2;

import java.util.function.Predicate;

public class LambdaPredicate {
    public static void main(String[] args) {
        Predicate <String> predi = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if(s.length() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        System.out.println(predi.test(""));
        System.out.println(predi.test("내일은 놉니다!!"));

        Predicate<String> predi2 = str -> str.isEmpty();

        System.out.println(predi2.test(""));
        System.out.println(predi2.test("내일은 놉니다!"));
    }
}
