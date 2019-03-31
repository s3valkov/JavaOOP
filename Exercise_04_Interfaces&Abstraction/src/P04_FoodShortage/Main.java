package P04_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peoples = Integer.parseInt(scanner.nextLine());

        List<Citizen> citizenList = new ArrayList<>();
        List<Rebel> rebelList = new ArrayList<>();

        while (peoples-- > 0) {
            String[] personInformation = scanner.nextLine().split("\\s+");
            if (personInformation.length == 4) {
                Citizen citizen = new Citizen(personInformation[0], Integer.parseInt(personInformation[1]), personInformation[2], personInformation[3]);
                citizenList.add(citizen);
            } else {
                Rebel rebel = new Rebel(personInformation[0], Integer.parseInt(personInformation[1]), personInformation[2]);
                rebelList.add(rebel);
            }
        }

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("End")) {
                break;
            }

            if (isPersonInTheRebelList(rebelList, line)) {
                rebelList.stream().filter(e -> e.getName().equals(line)).forEach(Rebel::buyFood);
            } else if (isPersonInTheCitizenList(citizenList, line)) {
                citizenList.stream().filter(e -> e.getName().equals(line)).forEach(Citizen::buyFood);
            }
        }

        int sumFood = rebelList.stream().mapToInt(Rebel::getFood).sum();//food of all Rebels
        sumFood += citizenList.stream().mapToInt(Citizen::getFood).sum();

        System.out.println(sumFood);
    }

    private static boolean isPersonInTheRebelList(List<Rebel> list, String name) {
        return list.stream().anyMatch(e -> e.getName().equals(name));
    }

    private static boolean isPersonInTheCitizenList(List<Citizen> list, String name) {
        return list.stream().anyMatch(e -> e.getName().equals(name));
    }


}
