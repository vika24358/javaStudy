package homework8;

public class Employee {
    String name;
    int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }

    public void displayInfo(){
        System.out.println("Name: " + name + "; age: " + age + "; salary:" + salary);
    }

    public void increaseSalary (int amount) {
        int newSalary = getSalary() + amount;
        setSalary(newSalary);
    }


}
