package nested.staticNested2;

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

        public static void showStatus() {
            System.out.println("지금 까지 팔린 차는 " + soldCount);
            System.out.println("마지막으로 팔린 차는 " + lastModel);
        }
    }
    
    public void drive() {
        Engine engine = new Engine();
        engine.start();
        System.out.println("차를 운전합니다");
    }
}
