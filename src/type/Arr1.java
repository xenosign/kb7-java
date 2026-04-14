package type;

public class Arr1 {
    public static void main(String[] args) {
        String[] students; // 배열이 시작되는 주소 값을 지정
        students = new String[6]; // 배열 생성 및 크기 설정
        
        students[0] = "최보윤";
        students[1] = "김건우";
        students[2] = "김민철";
        students[3] = "이아영";
        students[4] = "김기선";
        students[5] = "이지은";

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
