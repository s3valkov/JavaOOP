package P02_Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double a, double b) {
        this.height = a;
        this.width = b;
    }

    @Override
    public Double calculatePerimeter() {
        return height * 2 + width * 2;
    }

    @Override
    public Double calculateArea() {
        return height * width;
    }
}
