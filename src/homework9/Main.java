package homework9;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Parrot parrot = new Parrot();
        CustomAnimal human = new CustomAnimal("Hello, I'm a person");
        Fish fish = new Fish();

        Animal[] animals = {dog, cat, parrot, human};

        printAnimalActions(animals);
        printAnimalActions(fish);
    }

    public static void printAnimalActions(Animal[] animals){
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].makeSound());
        }
    }

    public static void printAnimalActions(Fish fish) {
        System.out.println(fish.swim());
    }
}
