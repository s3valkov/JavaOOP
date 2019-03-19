package P02_PointInRectangle;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    boolean isInRectangle(Point point) {
        boolean xCoordinate = topLeft.getX() <= point.getX() &&
                bottomRight.getX() >= point.getX();
        boolean yCoordinate = topLeft.getY() <= point.getY() &&
                bottomRight.getY() >= point.getY();

        return xCoordinate && yCoordinate;
    }
}
