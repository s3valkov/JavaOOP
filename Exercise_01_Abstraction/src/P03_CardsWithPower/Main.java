package P03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String card = scanner.nextLine();
        String cardSuit = scanner.nextLine();
        Card card1 = new Card(card, cardSuit);

        System.out.println(card1.toString());

    }
}
