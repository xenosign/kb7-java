package generic.method2;

import java.util.Scanner;

public class ApiResponseMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("요청하고자 하는 endpoint 를 입력 (1: /user, 2: /product) : ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("User 데이터 요청");
            User data = new User("이효석", "1234");
            ApiResponse<User> userRes = new ApiResponse<>(data, "OK", 200);
            System.out.println(userRes);
        } else if(choice == 2) {
            System.out.println("Product 데이터 요청");

        }
    }
}
