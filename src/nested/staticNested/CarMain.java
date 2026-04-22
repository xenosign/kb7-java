package nested.staticNested;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("미니 쿠퍼");
        car.drive();

        Car.CarStatus status = new Car.CarStatus(car);
        status.showStatus();
    }
}
