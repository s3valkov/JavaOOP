package P02_PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoordinates = coordinateReader(scanner.nextLine());
        int counter = Integer.parseInt(scanner.nextLine());

        Point top = new Point(rectangleCoordinates[0], rectangleCoordinates[1]);
        Point bottom = new Point(rectangleCoordinates[2], rectangleCoordinates[3]);
        Rectangle rectangle = new Rectangle(top, bottom);


        while (counter-- > 0) {
            int[] pointCoordinate = coordinateReader(scanner.nextLine());
            Point point = new Point(pointCoordinate[0], pointCoordinate[1]);

            System.out.println(rectangle.isInRectangle(point));
        }
    }

    public static int[] coordinateReader(String line) {
        int[] coordinates = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return coordinates;
    }
}
