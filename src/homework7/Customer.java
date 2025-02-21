package homework7;

public class Customer {
    private String name;
    private int money;

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public boolean buyAnimal(ZooShop shop, String animalName){
        for (int i = 0; i<shop.currentAnimalNumber; i++) {
            if (animalName.equals(shop.animals[i].getName()) && shop.animals[i].getPrice() <= money) {
                this.money -= shop.animals[i].getPrice();
                shop.removeAnimal(animalName);
                System.out.println("Purchase successful" );
                return true;
            }
        }return false;
    }

    public void displayInfo(){
        System.out.println(name + " " + money);
    }
}
