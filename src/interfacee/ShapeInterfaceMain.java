package interfacee;


public class ShapeInterfaceMain {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle("orange", 10, 10);
        Circle circle = new Circle("skyblue", 3);

        rec.printInfo();
        rec.printRectangle();
        circle.printInfo();
        circle.printCircle();
    }
}
