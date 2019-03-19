package P04_HotelReservation;

public enum CustomerType {
    None(0),
    SecondVisit(10),
    VIP(20);

    int discount;

    public double getDiscount() {
        return discount / 100.0;
    }

    CustomerType(int discount) {
        this.discount = discount;
    }
}
