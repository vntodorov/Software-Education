package PolymorphismLAB.Shapes;

public class Rectangle extends Shape {

    private Double height;

    private Double width;

    public Rectangle(Double height, Double width){
        this.height = height;
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * (height + width));
    }

    @Override
    protected void calculateArea() {
        setArea(height * width);
    }
}
