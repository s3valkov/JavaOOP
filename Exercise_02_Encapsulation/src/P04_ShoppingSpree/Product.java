package P04_ShoppingSpree;

import java.security.InvalidParameterException;

public class Product implements CharSequence {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < 1 || name.equals(" ") || name.equals("") || name.trim().equals(" ") || name.trim().equals("")) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new InvalidParameterException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public int length() {
        return this.name.length();
    }

    @Override
    public char charAt(int index) {
        return this.name.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return subSequence(start, end);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
