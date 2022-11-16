package WorkingWithAbstractionLAB.PointInRectangle;

public class Rectangle {

    private Point bottomLeft;

    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {

        int x = point.getX();
        int y = point.getY();

        return (x >= bottomLeft.getX() && x <= topRight.getX()) && (y >= bottomLeft.getY() && y <= topRight.getY());
    }


}
