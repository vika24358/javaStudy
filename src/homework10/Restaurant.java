package homework10;

import java.util.ArrayList;

public class Restaurant {
    private static ArrayList<Dish> dishes = new ArrayList<>();

    public static void addDish(Dish dish) {
        dishes.add(dish);
    }

    public static int getTotalDishes(){
        return dishes.size();
    }


}
