package polymorphism;

public class AnimalMain {
    public static void main(String[] args) {
        Animal donkey = new Donkey();
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal chicken = new Chicken();

        donkey.sound();
        dog.sound();
        cat.sound();
        chicken.sound();
    }
}
