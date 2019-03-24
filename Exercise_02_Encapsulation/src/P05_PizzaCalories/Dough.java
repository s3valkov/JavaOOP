package P05_PizzaCalories;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private static HashMap<String, Double> flourTypes;
    private static HashMap<String, Double> bakingTechniques;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    static {
        flourTypes = new LinkedHashMap<>();
        bakingTechniques = new LinkedHashMap<>();

        flourTypes.put("WHITE", 1.5);
        flourTypes.put("WHOLEGRAIN", 1.0);

        bakingTechniques.put("CRISPY", 0.9);
        bakingTechniques.put("CHEWY", 1.1);
        bakingTechniques.put("HOMEMADE", 1.0);
    }

    private void setFlourType(String flourType) {
        if (!flourTypes.containsKey(flourType.toUpperCase())) {
            throw new InvalidParameterException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechniques.containsKey(bakingTechnique.toUpperCase())) {
            throw new InvalidParameterException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new InvalidParameterException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.weight) * this.flourTypes.get(flourType.toUpperCase()) * this.bakingTechniques.get(bakingTechnique.toUpperCase());
    }

}
