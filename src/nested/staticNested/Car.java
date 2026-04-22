package nested.staticNested;

class Car {
    private String model;
    public boolean isStarted = false;
    private static int soldCount = 0;

    public Car(String model) {
        soldCount++;
        CarStatus.lastModel = model;
        this.model = model;
    }

    private class Engine {
        void start() {
            isStarted = true;
            System.out.println("엔진이 가동됩니다.");
        }
    }

    public static class CarStatus {
        static private String lastModel;
        private Car car;

        public CarStatus(Car car) {
            this.car = car;
        }

        public void showStatus() {
            System.out.println("지금 까지 팔린 차는 " + soldCount);
            System.out.println("지금 차는 " + car.model);
        }
    }
    
    public void drive() {
        Engine engine = new Engine();
        engine.start();
        System.out.println("차를 운전합니다");
    }
}
