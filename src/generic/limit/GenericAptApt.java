package generic.limit;

public class GenericAptApt<T extends Number> {
    private T number;

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public double transDouble() {
        return this.number.doubleValue();
    }

    @Override
    public String toString() {
        return "GenericApartApart{" +
                "number=" + number +
                '}';
    }
}
