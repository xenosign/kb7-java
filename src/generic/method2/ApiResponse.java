package generic.method2;

public class ApiResponse<T> {
    private T data;
    private String message;
    private int status;

    public ApiResponse() {}
    public ApiResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, "OK", 200);
    }

    public static <T> ApiResponse<T> error() {
        return new ApiResponse<>(null, "ERROR", 500);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
