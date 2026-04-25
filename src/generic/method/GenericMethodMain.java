package generic.method;

public class GenericMethodMain {
    public static void main(String[] args) {
        Integer value = GenericMethod.<Integer>genericMethod(10);
        Integer value2 = GenericMethod.genericMethod(10);
        System.out.println(value);

//        GenericMethod.<String>genericMethod(10);


    }
}
