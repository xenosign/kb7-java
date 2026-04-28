package generic.method;

public class GenericMethodMain {
    public static void main(String[] args) {
        GenericAptApt<Integer> integerAptApt = new GenericAptApt<>();
        String type = integerAptApt.genericMethod1(10).getClass().getName();
        System.out.println(type);

        String str = integerAptApt.<String>genericMethod2("문자열");
        System.out.println(str);

        String str2 = GenericAptApt.genericMethod2("문자열");
        System.out.println(str2);

        Double doubleValue = GenericAptApt.<Double>numberMethod(10.3);

//        String str3 = GenericAptApt.<String>numberMethod("문자열");
    }
}
