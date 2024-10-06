package pr4.pr41;

public class Shape {
    protected String type;
    protected double area;
    protected double perimeter;

    public String getType() {
        return type;
    }
    public double getArea() {
        return area;
    }
    public double getPerimeter() {
        return perimeter;
    }
    @Override
    public String toString() {
        return "Type = " + getType() +
                ", Area = " + getArea() +
                ", Perimeter = " + getPerimeter();
    }
}
