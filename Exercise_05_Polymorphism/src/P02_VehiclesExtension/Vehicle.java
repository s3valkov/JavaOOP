package P02_VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;
    private double ADDITIONALFUEL;

    public Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity, double ADDITIONALFUEL) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
        this.ADDITIONALFUEL = ADDITIONALFUEL;
    }

    public void setADDITIONALFUEL(double ADDITIONALFUEL) {
        this.ADDITIONALFUEL = ADDITIONALFUEL;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }


    public String getRefueled(double fuel) {
        if (fuel <= 0) {
            return "Fuel must be a positive number";
        }
        if (fuelQuantity + fuel > this.tankCapacity) {
            return "Cannot fit fuel in tank";
        }
        this.setFuelQuantity(this.fuelQuantity + fuel);
        return "";
    }

    public String drive(double distance) {
        double totalFuelConsumption = this.getLitersPerKm() + ADDITIONALFUEL;

        if (totalFuelConsumption * distance > this.getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.setFuelQuantity(this.getFuelQuantity() - totalFuelConsumption * distance);
        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("%s travelled %s km"
                , this.getClass().getSimpleName()
                , df.format(distance));
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f"
                , this.getClass().getSimpleName()
                , this.getFuelQuantity());
    }
}
