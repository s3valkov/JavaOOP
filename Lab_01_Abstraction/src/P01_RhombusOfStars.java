import java.util.Scanner;

public class P01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeFigure = Integer.parseInt(scanner.nextLine());
        //print Upper Body (+ middle Part)
        for (int starCounter = 1; starCounter <= sizeFigure; starCounter++) {
            printRow(sizeFigure, starCounter);
        }
        //print the Rest
        for (int starCounter = sizeFigure - 1; starCounter > 0; starCounter--) {
            printRow(sizeFigure, starCounter);
        }

    }


    public static void printRow(int sizeFigure, int starCounter) {
        printSpaces(sizeFigure - starCounter);
        for (int i = 0; i < starCounter; i++) {
            System.out.printf("* ");
        }
        System.out.println();
    }

    public static void printSpaces(int starCounter) {
        for (int i = starCounter; i > 0; i--) {
            System.out.print(" ");
        }
    }
}
