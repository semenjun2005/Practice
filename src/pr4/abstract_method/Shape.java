package pr4.abstract_method;

public abstract class Shape {
    public abstract String getType();
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString(){
        return "type = " + getType() +
                ", area = " + Math.round(getArea()) +
                ", perimeter = " + Math.round(getPerimeter());
    }
}
