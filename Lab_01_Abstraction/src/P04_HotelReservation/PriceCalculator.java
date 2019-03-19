package P04_HotelReservation;

public class PriceCalculator {

    public static double calculate(ReservationDetails details) {
        double price = details.getNumberOfDays() * details.getPricePerDay();
        price *= details.getSeason().getValue();

       price *= 1 - details.getType().getDiscount();

        return price;
    }

}
