package p06_TirePressureMonitoringSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class chernova {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] gamesKeys = scanner.nextLine().split("&");

        List<StringBuilder> output = new ArrayList<>();
        for (String gamesKey : gamesKeys) {
            if (isValidKey(gamesKey)) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < gamesKey.length(); i++) {
                    char symbol = gamesKey.charAt(i);
                    if (Character.isLetter(symbol)) {
                        char change = Character.toUpperCase(symbol);
                        result.append(change);

                    } else if (Character.isDigit(symbol)) {
                        char changeNumber = (char) ('9' - (symbol - '0'));
                        result.append(changeNumber);
                    }
                }
                output.add(result);
            }
        }
        int count = output.size();
        for (StringBuilder builder : output) {

            for (int i = 0; i < builder.length(); i++) {
                if (builder.length() == 25) {
                    char symbol = builder.charAt(i);
                    if ((i + 1) % 5 == 0 && i != builder.length() - 1) {
                        System.out.print(symbol);
                        System.out.print("-");
                    } else {
                        System.out.print(symbol);
                    }
                } else if (builder.length() == 16) {
                    char symbol = builder.charAt(i);
                    if ((i + 1) % 4 == 0 && i != builder.length() - 1) {
                        System.out.print(symbol);
                        System.out.print("-");
                    } else {
                        System.out.print(symbol);
                    }

                }


            }
            count--;
            if (count != 0) {
                System.out.print(", ");
            }
        }
    }


    private static boolean isValidKey(String gamesKey) {
        for (int i = 0; i < gamesKey.length(); i++) {
            if (!Character.isLetter(gamesKey.charAt(i)) && !Character.isDigit(gamesKey.charAt(i)) && (gamesKey.length() < 16 || gamesKey.length() > 25)) {
                return false;
            }

        }
        return true;
    }
}