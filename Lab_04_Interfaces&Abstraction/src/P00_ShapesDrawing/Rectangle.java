package P00_ShapesDrawing;

public class Rectangle implements Drawable {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void draw() {
        for (int i = 0; i < this.getHeight(); i++) {
            System.out.print("*");
            for (int j = 0; j < this.getWidth() - 1; j++) {
                System.out.print(" ");
                if (i == 0 || i == (this.height - 1)) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.print(" ");
            System.out.print("*");
            System.out.println();
        }

    }
}
