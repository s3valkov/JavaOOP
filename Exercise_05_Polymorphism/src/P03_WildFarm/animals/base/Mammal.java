package P03_WildFarm.animals.base;

import P03_WildFarm.food.Food;
import P03_WildFarm.food.Vegetable;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingReligion;

    public Mammal(String animalName, String animalType, Double animalWeight,String livingReligion) {
        super(animalName, animalType, animalWeight);
        this.livingReligion = livingReligion;
    }


    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        } else {
            String animalType = "Zebras";
            if (this.getClass().getSimpleName().equals("Mouse")) {
                animalType = "Mice";
            }
            System.out.println(animalType + " are not eating that type of food!");
        }
    }

    public String getLivingReligion() {
        return livingReligion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s]"
                , this.getAnimalType()
                , this.getAnimalName()
                , df.format(this.getAnimalWeight())
                , this.getLivingReligion()
                , this.getFoodEaten());
    }
}
