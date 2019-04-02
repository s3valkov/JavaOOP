package P01_Vehicles;


public class Truck extends Vehicles {


    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm, 1.6);
    }

    @Override
    void getRefueled(double fuel) {
        super.setFuelQuantity(this.getFuelQuantity() + fuel * 0.95);
    }

}
