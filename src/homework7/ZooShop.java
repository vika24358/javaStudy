package homework7;

public class ZooShop {
    Animal[] animals;
    int currentAnimalNumber = 0;
    int maxSize;

    public ZooShop(int maxSize) {
        this.animals = new Animal[maxSize];
        this.maxSize = maxSize;
    }

    public void addAnimal(Animal animal){
        if (currentAnimalNumber<maxSize) {
            animals[currentAnimalNumber] = animal;
            currentAnimalNumber++;
        }
    }

    public void removeAnimal(String name){
        for(int i = 0; i< currentAnimalNumber; i++){
            if (animals[i].name.equals(name)) {
                for (int j = i; j < currentAnimalNumber -1; j++) {
                    animals[j] = animals[j +1];
                }
                animals[currentAnimalNumber - 1] = null;
                currentAnimalNumber --;
            }
        }
    }

    public void displayAnimals(){
        for (int i = 0; i < currentAnimalNumber; i++) {
            animals[i].displayInfo();
        }
    }

    public String findAnimal (String name) {
        for (int i = 0; i < currentAnimalNumber; i++) {
            if (animals[i].name.equals(name)) {
                return animals[i].name;
            }
        }
    return null;
    }
}
