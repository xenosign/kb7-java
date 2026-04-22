package nested.inner;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("미니 쿠퍼");

        car.drive();

        Engine engine = new Engine();
        engine.start();

        car.isStarted = true;

        car.drive();
    }
}
