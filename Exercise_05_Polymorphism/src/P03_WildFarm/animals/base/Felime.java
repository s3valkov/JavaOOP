package P03_WildFarm.animals.base;

import P03_WildFarm.food.Food;

public abstract class Felime extends Mammal {


    public Felime(String animalName, String animalType, Double animalWeight, String livingReligion) {
        super(animalName, animalType, animalWeight, livingReligion);
    }

    @Override
    public void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}
