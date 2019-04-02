package P02_VehiclesExtension;


public class Truck extends Vehicle {


    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm, tankCapacity, 1.6);
    }

    @Override
    public String getRefueled(double fuel) {
        if (fuel <= 0) {
            return "Fuel must be a positive number";
        }
        if (this.getFuelQuantity() + fuel * 0.95 > super.getTankCapacity()) {
            return "Cannot fit fuel in tank";
        }

        this.setFuelQuantity(this.getFuelQuantity() + fuel * 0.95);
        return "";
    }
}
