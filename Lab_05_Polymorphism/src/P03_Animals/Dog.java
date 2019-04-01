package P03_Animals;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my fovourite food is %s DJAAF"
                , super.getName(), super.getFavoriteFood());
    }
}

