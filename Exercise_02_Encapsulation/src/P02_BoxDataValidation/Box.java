package P02_BoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }

        this.length = length;
    }

    public void setWidth(double width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }

        this.width = width;
    }

    public void setHeight(double height) {
        if (height < 1) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f"
                , this.calculateSurfaceArea()
                , this.calculateLateralSurfaceArea()
                , this.calculateVolume());
    }
}
