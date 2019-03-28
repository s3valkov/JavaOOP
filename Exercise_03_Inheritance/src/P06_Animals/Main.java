package P06_Animals;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String line = scanner.nextLine();

            if (line.equals("Beast!")){
                break;
            }

            try {
                String[] animalInfo = scanner.nextLine().split("\\s+");
                Cat cat = new Cat(animalInfo[0],Integer.parseInt(animalInfo[1]),animalInfo[2]);
                System.out.println(cat.toString());
            }catch (InvalidParameterException ex){
                System.out.println(ex.getMessage());
            }

        }
    }
}
