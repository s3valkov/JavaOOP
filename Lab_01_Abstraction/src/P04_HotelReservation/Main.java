package P04_HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        double price = Double.parseDouble(input[0]);
        int numbersOfDay = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        CustomerType type = CustomerType.valueOf(input[3]);
        ReservationDetails details = new ReservationDetails(price, numbersOfDay, season, type);

        System.out.printf("%.2f\n"
                , PriceCalculator.calculate(details));
    }
}
