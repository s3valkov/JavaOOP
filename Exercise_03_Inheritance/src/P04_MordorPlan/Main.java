package P04_MordorPlan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        Gandalf gandalf = new Gandalf();

        for (String food : line) {
            gandalf.eatFood(food);
        }

        System.out.println(gandalf.getFoodPoints());
        System.out.println(gandalf.getMood());
    }
}
