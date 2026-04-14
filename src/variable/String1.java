package variable;

public class String1 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";

        boolean result1 = "abc".equals("abc");
        boolean result2 = "abc".equals("def");
        boolean result3 = "abc".equals(str1);
        boolean result4 = "abc".equals(str2);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);


    }
}
