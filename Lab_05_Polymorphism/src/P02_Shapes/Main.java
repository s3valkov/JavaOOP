package P02_Shapes;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Rectangle(4,7);

        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());
    }
}
