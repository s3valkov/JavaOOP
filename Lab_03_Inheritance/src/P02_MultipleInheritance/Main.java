package P02_MultipleInheritance;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
        Puppy puppy = new Puppy();
        puppy.weep();
    }
}
