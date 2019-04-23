package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidAlgorithmParameterException;

import static org.junit.Assert.*;

public class CarTest {
    private final static String model = "BMW";
    private final double tankCapacity = 30;
    private final double fuelAmount = 22;
    private final double consumptionPerKm = 4;
    private Car car;


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS CAR
    @Before
    public void beforeMethod() {
        car = new Car(model, tankCapacity, fuelAmount, consumptionPerKm);
    }


    @Test
    public void shouldReturnModel() {
        String model = this.car.getModel();
        Assert.assertEquals("Should return the correct model of the car", model, "BMW");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInvalidModel() {
        this.car.setModel(null);
    }

    @Test
    public void shouldReturnTankCapacity() {
        double capacity = car.getTankCapacity();
        Assert.assertEquals(30, capacity, 0);
    }

    @Test
    public void shouldReturnFuelAmount() {
        double amount = car.getFuelAmount();
        Assert.assertEquals(22, amount, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfFuelAmountIsMoreThanCapacity() {
        this.car.setFuelAmount(45);
    }

    @Test
    public void shouldReturnFuelConsumptionPerKm() {
        double consumption = car.getFuelConsumptionPerKm();
        Assert.assertEquals(4, consumption, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfFuelConsumptionIsNegative() {
        this.car.setFuelConsumptionPerKm(-2);
    }

    @Test(expected = IllegalStateException.class)
    public void refuelShouldThrowExceptionIfTheFuelIsMore(){
        car.refuel(20);
    }

    @Test
    public void shouldSetCorrectFuelAmountAfterRefuel(){
        car.refuel(5);
        double fuelAmountAfterRefuel = car.getFuelAmount();
        Assert.assertEquals(27,fuelAmountAfterRefuel,0);
    }

    @Test
    public void shouldReturnAMessage(){
        String actual = car.drive(4);
        String expected = "Have a nice trip";
        Assert.assertEquals(actual,expected);
    }

    @Test(expected = IllegalStateException.class)
    public void driveShouldReturnThrowException(){
        car.drive(22);
    }




}