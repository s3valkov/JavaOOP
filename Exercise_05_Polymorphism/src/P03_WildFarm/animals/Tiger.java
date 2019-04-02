package P03_WildFarm.animals;

import P03_WildFarm.animals.base.Felime;
import P03_WildFarm.food.Food;
import P03_WildFarm.food.Meat;

public class Tiger extends Felime {


    public Tiger(String animalName, String animalType, Double animalWeight, String livingReligion) {
        super(animalName, animalType, animalWeight, livingReligion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }
        else{
            System.out.println(this.getAnimalType() + "s are not eating that type of food!");
        }
    }
}
