package polymorphism;

public class AnimalPolyMain4 {
    public static void main(String[] args) {
       Animal animal = new Animal();

       Cat yourAreNowCat = (Cat) animal;
       yourAreNowCat.grooming();
    }

    private static void soundAnimal(Animal animal) {
        animal.sound();
    }
}
