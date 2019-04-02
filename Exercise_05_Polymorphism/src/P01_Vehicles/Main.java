package P01_Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicleInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(vehicleInfo[1]), Double.parseDouble(vehicleInfo[2]));
        vehicleInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(vehicleInfo[1]), Double.parseDouble(vehicleInfo[2]));

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            vehicleInfo = scanner.nextLine().split("\\s+");
            double fuelInfo = Double.parseDouble(vehicleInfo[2]);

            if (vehicleInfo[0].equals("Drive")) {

                if (vehicleInfo[1].equals("Car")) {
                    System.out.println(car.drive(fuelInfo));
                } else {
                    System.out.println(truck.drive(fuelInfo));
                }

            } else {

                if (vehicleInfo[1].equals("Car")) {
                    car.getRefueled(fuelInfo);
                } else {
                    truck.getRefueled(fuelInfo);
                }

            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
