package P05_PizzaCalories;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Topping {
    private String toppingType;
    private double weight;
    private static HashMap<String, Double> toppingModifiers;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    static {
        toppingModifiers = new LinkedHashMap<>();

        toppingModifiers.put("MEAT", 1.2);
        toppingModifiers.put("VEGGIES", 0.8);
        toppingModifiers.put("CHEESE", 1.1);
        toppingModifiers.put("SAUCE", 0.9);
    }

    private void setToppingType(String toppingType) {
        if (!toppingModifiers.containsKey(toppingType.toUpperCase())) {
            throw new InvalidParameterException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new InvalidParameterException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.weight) * this.toppingModifiers.get(toppingType.toUpperCase());
    }


}
