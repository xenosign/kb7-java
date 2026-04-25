package generic.ex1;

public class GenericBoxMain {
    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setValue(10);
        System.out.println(integerBox.getValue());

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setValue("내일 쉰다~ 오예");
        System.out.println(stringBox.getValue());
    }
}
