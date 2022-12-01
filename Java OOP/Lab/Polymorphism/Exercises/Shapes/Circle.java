package PolymorphismLAB.Shapes;

public class Circle extends Shape {

    private Double radius;


    public final Double getRadius() {
        return radius;
    }


    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * radius * radius);
    }
}
