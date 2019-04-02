package P03_WildFarm.animals;

import P03_WildFarm.animals.base.Mammal;

public class Zebra extends Mammal {


    public Zebra(String animalName, String animalType, Double animalWeight, String livingReligion) {
        super(animalName, animalType, animalWeight, livingReligion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }


}
