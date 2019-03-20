package P01_CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cmd = scanner.nextLine();
        System.out.println(cmd + ":");
        Arrays.stream(CardSuit.values())
                .forEach(System.out::println);
    }
}
