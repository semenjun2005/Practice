package pr4.pr41;

public class Tester {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape square = new Square(4);


        Shape[] shapes = {circle, rectangle, square};

        for (Shape shape : shapes) {

            System.out.println(shape);
        }
    }
}
