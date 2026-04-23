package lang.clazz;

import java.lang.reflect.Field;

public class ClazzMain {
    public static void main(String[] args) throws Exception {
        Class clazz1 = User.class;
        Class clazz2 = new User("효석", "xenosign").getClass();
        Class clazz3 = Class.forName("lang.clazz.User");

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz2);

        Field[] fields = clazz1.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        User user = (User) clazz1.getDeclaredConstructor().newInstance();
        System.out.println(user);

    }
}
