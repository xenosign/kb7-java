package classs;

public class FishBreadMain {
    public static void main(String[] args) {
        FishBread fish1 = new FishBread("슈크림", "붕어", 500);
        fish1.printFishBread();

        FishBread fish2 = new FishBread();
        fish2.printFishBread();
    }
}
