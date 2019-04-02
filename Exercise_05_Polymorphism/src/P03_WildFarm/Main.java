package P03_WildFarm;

import P03_WildFarm.animals.*;
import P03_WildFarm.animals.base.Animal;
import P03_WildFarm.food.Food;
import P03_WildFarm.food.Meat;
import P03_WildFarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int counter = 0;
        Animal animal = null;
        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();
        while (!input.equals("End")) {
            String[] lines = input.split("\\s+");

            if (counter % 2 == 0) {
                String animalType = lines[0];
                String animalName = lines[1];
                double animalWeight = Double.parseDouble(lines[2]);
                String animalLivingRegion = lines[3];

                if (animalType.equals("Cat")) {
                    String breed = lines[4];
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                } else if (animalType.equals("Tiger")) {
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                } else if (animalType.equals("Zebra")) {
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                } else if (animalType.equals("Mouse")) {
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                }
                animals.add(animal);
            } else {
                String foodType = lines[0];
                int foodQuantity = Integer.parseInt(lines[1]);
                Food food = null;
                if (foodType.equals("Meat")) {
                    food = new Meat(foodQuantity);
                } else if (foodType.equals("Vegetable")) {
                    food = new Vegetable(foodQuantity);
                }

                animals.get(animals.size() - 1).makeSound();
                animal.eat(food);
            }


            input = bufferedReader.readLine();
            counter++;
        }
        animals.forEach(System.out::println);
    }
}