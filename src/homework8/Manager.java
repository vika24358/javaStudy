package homework8;

public class Manager extends Employee{
    int bonus;

    public Manager (String name, int age, int salary, int bonus){
        super(name, age, salary);
        this.bonus = bonus;
    }

    public void displayInfo(){
        System.out.println("Manager:");
        super.displayInfo();
        System.out.println("bonus: " + bonus);
    }
}
