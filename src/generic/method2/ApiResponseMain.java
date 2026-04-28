package generic.method2;

import java.util.Scanner;

public class ApiResponseMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("요청하고자 하는 endpoint 를 입력 (1: /user, 2: /product) : ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("User 데이터 요청");
            ApiResponse<User> userRes = new ApiResponse<User>();
            System.out.println(userRes.success(new User("이효석", "1234")));
        } else if(choice == 2) {
            System.out.println("Product 데이터 요청");
            ApiResponse<Product> productRes = new ApiResponse<Product>();
            System.out.println(productRes.error());
        }
    }
}
