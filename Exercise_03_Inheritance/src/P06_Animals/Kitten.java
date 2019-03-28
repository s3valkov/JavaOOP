package P06_Animals;

import java.security.InvalidParameterException;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
        this.setGender(gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.toLowerCase().equals("female")) {
            throw new InvalidParameterException("Invalid input!");
        }
        super.setGender(gender);
    }

    @Override
    protected String produceSound() {
        return "Miau";
    }
}
