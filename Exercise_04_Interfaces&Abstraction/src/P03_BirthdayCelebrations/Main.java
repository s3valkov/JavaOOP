package P03_BirthdayCelebrations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("End")) {
                break;
            }

            String[] information = line.split("\\s+");
            String category = information[0];

            if (category.equals("Citizen")) {
                Citizen citizen = new Citizen(information[1], Integer.parseInt(information[2]), information[3], information[4]);
                System.out.println(citizen.getBirthDate());
            } else if (category.equals("Pet")) {
                Pet pet = new Pet(information[1], information[2]);
                System.out.println(pet.getName());
            } else {
                Robot robot = new Robot(information[1], information[2]);
                System.out.println(robot.getModel());
            }


        }
    }
}
