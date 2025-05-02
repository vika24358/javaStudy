package homework10;

public class Dish {
    String name;
    int price;
    String category;

    public Dish(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void displayInfo(){
        System.out.println("Назва: " + name + ", Ціна: " + price + ", Категорія: " + category);
    }
}
