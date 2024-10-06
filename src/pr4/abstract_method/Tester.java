package pr4.abstract_method;

public class Tester {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape square = new Square(4);

        // Массив фигур
        Shape[] shapes = {circle, rectangle, square};

        for (Shape shape : shapes) {
            // Вывод информации о фигуре
            System.out.println(shape);
        }
    }
}