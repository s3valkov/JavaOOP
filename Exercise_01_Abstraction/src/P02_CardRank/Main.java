package P02_CardRank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine() + ":");

        Arrays.stream(CardRank.values())
                .forEach(System.out::println);
    }
}
