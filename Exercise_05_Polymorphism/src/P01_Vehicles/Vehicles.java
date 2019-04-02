package P01_Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double litersPerKm;
    private final double ADDITIONALFUEL;

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

    public Vehicles(double fuelQuantity, double litersPerKm, double ADDITIONALFUEL) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.ADDITIONALFUEL = ADDITIONALFUEL;
    }

    abstract void getRefueled(double fuel);

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

    @Override
    public String toString() {
        return String.format("%s: %.2f"
                , this.getClass().getSimpleName()
                , this.getFuelQuantity());
    }
}
