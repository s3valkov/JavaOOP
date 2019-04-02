package P03_WildFarm.animals;

import P03_WildFarm.animals.base.Felime;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingReligion, String breed) {
        super(animalName, animalType, animalWeight, livingReligion);
        this.breed = breed;
    }


    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %s]"
                , this.getAnimalType()
                , this.getAnimalName()
                , this.getBreed()
                , df.format(this.getAnimalWeight())
                , this.getLivingReligion()
                , this.getFoodEaten());
    }
}
