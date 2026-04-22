package nested.local;

import java.util.Date;

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
        class DriveLog {
            private final Date date;
            private int count = 0;

            DriveLog(Date date) {
                this.date = date;
            }

            void log() {
                count++;
                System.out.println("[기록] " + model + " " + date.toString() + " 에 운전 시작, " + count + " 번째 로그");
            }
        }

        Engine engine = new Engine();
        engine.start();

        DriveLog driveLog = new DriveLog(new Date());
        driveLog.log();
        driveLog.log();

        System.out.println("차를 운전합니다");
    }
}
