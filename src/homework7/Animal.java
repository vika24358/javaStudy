package homework7;

public class Animal {
    private String name;
    private int age;
    private String breed;
    private int price;

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
