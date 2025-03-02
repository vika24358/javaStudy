package homework8;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Vika", 17, 50000, 5000);
        Manager manager1 = new Manager("Oleg", 19, 10000, 5000);
        Developer developer = new Developer("Kate", 18, 40000, "Java");
        Developer developer1 = new Developer("Olga", 17, 40000, "Python");

        manager.increaseSalary(manager.bonus);
        manager.displayInfo();
        manager1.displayInfo();
        developer.displayInfo();
        developer1.displayInfo();

    }
}
