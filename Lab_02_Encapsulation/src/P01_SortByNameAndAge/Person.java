package P01_SortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old."
                , this.getFirstName(), this.getLastName(), this.getAge());
    }
}
