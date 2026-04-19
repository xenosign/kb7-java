package polymorphism;

public class AnimalPolyMain5 {
    public static void main(String[] args) {
        Donkey donkey = new Donkey();
        Mosquito mosquito = new Mosquito();

        System.out.println(donkey instanceof Animal);
//        System.out.println(mosquito instanceof Animal);
    }
}
