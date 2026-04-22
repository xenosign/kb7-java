package nested.staticNested2;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("미니 쿠퍼");
        car.drive();

        Car.CarStatus.showStatus();
    }
}
