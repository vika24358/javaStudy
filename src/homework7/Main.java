package homework7;

public class Main {
    public static void main(String[] args) {
        ZooShop shop = new ZooShop(10); // Створюємо зоомагазин на 10 тварин

        Animal cat = new Animal("Барсик", 3, "Сибірська", 500);
        Animal dog = new Animal("Рекс", 5, "Німецька вівчарка", 1000);

        shop.addAnimal(cat);
        shop.addAnimal(dog);

        shop.displayAnimals();

        Customer customer = new Customer("Іван", 1200);
        customer.displayInfo();

        customer.buyAnimal(shop, "Рекс");
        customer.displayInfo();

        shop.displayAnimals(); // Виводимо оновлений список тварин в магазині
    }
}
