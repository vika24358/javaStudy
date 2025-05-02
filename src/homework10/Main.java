package homework10;

public class Main {
    public static void main(String[] args) {
        Dish pizza = new Dish("Піца", 350, "піца");
        Dish soup = new Dish("Суп", 200, "основна страва");
        Dish iceCream = new Dish("Морозиво", 180, "десерт");
        Dish cake = new Dish("Торт", 190, "десерт");

        Restaurant.addDish(pizza);
        Restaurant.addDish(soup);
        Restaurant.addDish(iceCream);
        Restaurant.addDish(cake);


        pizza.displayInfo();
        soup.displayInfo();
        iceCream.displayInfo();
        cake.displayInfo();
        System.out.println(Restaurant.getTotalDishes());
    }
}
