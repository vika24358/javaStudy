package homework7;

public class Customer {
    String name;
    int money;

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public boolean buyAnimal(ZooShop shop, String animalName){
        for (int i = 0; i<shop.currentAnimalNumber; i++) {
            if (animalName.equals(shop.animals[i].name) && shop.animals[i].price <= money) {
                this.money -= shop.animals[i].price;
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
