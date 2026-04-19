package polymorphism;

public class AnimalPolyMain3 {
    public static void main(String[] args) {
       Animal cat = new Cat();

       Cat catPoly = (Cat) cat;
       catPoly.grooming();
    }

    private static void soundAnimal(Animal animal) {
        animal.sound();
    }
}
