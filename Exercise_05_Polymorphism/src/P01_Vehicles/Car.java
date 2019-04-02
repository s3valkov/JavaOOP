package P01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicles {


    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm,0.9);
        this.setLitersPerKm(litersPerKm);
    }

    @Override
    void getRefueled(double fuel) {
        super.setFuelQuantity(this.getFuelQuantity() + fuel);
    }



}
