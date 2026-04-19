package polymorphism;

public class AnimalPolyMain6 {
    public static void main(String[] args) {
        Animal[] animals = { new Donkey(), new Dog(), new Cat(), new Chicken() };

        for (Animal animal : animals) {
            soundAnimal(animal);
        }

    }
    private static void soundAnimal(Animal animal) {
        animal.sound();

        if (animal instanceof Cat) {
            Cat poly = (Cat) animal;
            poly.grooming();
        }
    }
}
