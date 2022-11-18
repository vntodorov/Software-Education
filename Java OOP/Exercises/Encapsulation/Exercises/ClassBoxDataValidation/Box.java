package EncapsulationEXERCISES.ClassBoxDataValidation;

public class Box {

    private double length;

    private double width;

    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        sideValidation(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        sideValidation(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        sideValidation(height, "Height");
        this.height = height;
    }

    private void sideValidation(double side, String sideName) {
        if (side <= 0) {
            throw new IllegalArgumentException(sideName + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return (2 * length * width) + (2 * length * height) + (2 * width * height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);

    }

    public double calculateVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f", this.calculateSurfaceArea(), this.calculateLateralSurfaceArea(), this.calculateVolume());
    }


}
