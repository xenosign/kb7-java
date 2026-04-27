package generic.quiz;

public class GenericQuiz1<T> {
    public T quizMethod1(T t) { return t; }
    public static <T> T quizMethod2(T t) { return t; }
}
