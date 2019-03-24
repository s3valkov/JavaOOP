package P03_AnimalFarm;

import java.security.InvalidParameterException;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public void setName(String name) {
        if (name.length() < 1) {
            throw new InvalidParameterException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new InvalidParameterException("Age should be between 0 and 15.");
        }

        this.age = age;
    }

    private double calculateProductPerDay() {
        double eggs;

        if (this.age > -1 && this.age < 6) {
            eggs = 2;
        } else if (this.age > 5 && this.age < 12) {
            eggs = 1;
        } else {
            eggs = 0.75;
        }

        return eggs;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %f per day."
                , this.name
                , this.age
                , this.productPerDay());
    }
}
