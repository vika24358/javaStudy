package homework7;

public class Animal {
    String name;
    int age;
    String breed;
    int price;

    public Animal (String name, int age, String breed, int price) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getBreed(){
        return breed;
    }

    public int getPrice(){
        return price;
    }

    public void displayInfo(){
        System.out.println(name + " " + age + " " + breed + " " + price);
    }
}
