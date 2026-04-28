package generic.limit;

public class World1 {
    public static void main(String[] args) {
        GenericAptApt<Integer> integerAptApt1 = new GenericAptApt<>();
        integerAptApt1.setNumber(1118);
        integerAptApt1.transDouble();
        System.out.println(integerAptApt1.getNumber());

        GenericAptApt<Long> longAptApt = new GenericAptApt<>();
        longAptApt.setNumber(1118L);
        longAptApt.transDouble();
        System.out.println(longAptApt.getNumber());
    }
}
