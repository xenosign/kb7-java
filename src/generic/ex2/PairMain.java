package generic.ex2;

public class PairMain {
    public static void main(String[] args) {
        Pair<String, String>  nameData    = new Pair<>("name", "이효석");
        Pair<String, Integer> ageData     = new Pair<>("age", 42);
        Pair<String, Boolean> marriedData = new Pair<>("married", false);
        // 이거 인텔리제이 자동 추천으로 완성한건데 왜 바로 false 넣는거죠? -_-+;;;;;;;;

        // Getter 로 데이터 출력
        System.out.println("nameData value : " + nameData.getValue());
        System.out.println("ageData value : " + ageData.getValue());
        System.out.println("marriedData value : " + marriedData.getValue());

        // toString 으로 인스턴스 출력
        System.out.println(nameData);
        System.out.println(ageData);
        System.out.println(marriedData);
    }
}