package P04_ShoppingSpree;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person() {
        this.products = new ArrayList<>();
    }

    public Person(String name, double money) {
        this();
        this.setName(name);
        this.setMoney(money);
    }

    public void setName(String name) {
        if (name.length() < 1 || name.equals(" ") || name.equals("") || name.trim().equals(" ") || name.trim().equals("")) {
            throw new InvalidParameterException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new InvalidParameterException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        try {
            this.setMoney(this.money - product.getCost());
            System.out.printf("%s bought %s%n", this.name, product.toString());
            products.add(product);
        } catch (InvalidParameterException ex) {
            throw new InvalidParameterException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        }

        return this.name + " - " + String.join(", ", this.products);

    }
}
