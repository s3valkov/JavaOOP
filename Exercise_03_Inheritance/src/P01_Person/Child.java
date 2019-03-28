package P01_Person;

import java.security.InvalidParameterException;

public class Child extends Person {
    private String name;
    private int age;

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15) {
            throw new InvalidParameterException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }



}

