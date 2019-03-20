package P04_TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(s -> new Light(Signal.valueOf(s)))
                .toArray(Light[]::new);

        int numbersOfChanges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbersOfChanges; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[j].changeSignal();
                System.out.print(lights[j] + " ");
            }
            System.out.println();
        }
    }
}
