package P02_VehiclesExtension;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = createVehicle(scanner);
        Vehicle truck = createVehicle(scanner);
        Vehicle bus = createVehicle(scanner);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        while (numberOfCommands-- > 0) {
            String[] vehicleInfo = scanner.nextLine().split("\\s+");
            double fuelInfo = Double.parseDouble(vehicleInfo[2]);
            String toPrint = "";

            if (vehicleInfo[0].equals("Drive")) {

                if (vehicleInfo[1].equals("Car")) {
                    toPrint = car.drive(fuelInfo);
                } else if (vehicleInfo[1].equals("Truck")) {
                    toPrint = truck.drive(fuelInfo);
                } else {
                    bus.setADDITIONALFUEL(1.4);
                    toPrint = bus.drive(fuelInfo);
                }

            } else if (vehicleInfo[0].equals("Refuel")) {

                if (vehicleInfo[1].equals("Car")) {
                    toPrint = car.getRefueled(fuelInfo);
                } else if (vehicleInfo[1].equals("Truck")) {
                    toPrint = truck.getRefueled(fuelInfo);
                } else {
                    toPrint = bus.getRefueled(fuelInfo);
                }

            } else {
                bus.setADDITIONALFUEL(0);
                toPrint = bus.drive(fuelInfo);
            }

            if (toPrint.length() > 1) {
                System.out.println(toPrint);
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }


    private static Vehicle createVehicle(Scanner scanner) {
        String[] lines = scanner.nextLine().split("\\s+");

        String vehicleType = lines[0];
        double fuelQuantity = Double.parseDouble(lines[1]);
        double fuelConsumption = Double.parseDouble(lines[2]);
        double tankCapacity = Double.parseDouble(lines[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
            default:
                return null;
        }
    }
}
