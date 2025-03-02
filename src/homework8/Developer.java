package homework8;

public class Developer extends Employee{
    String programmingLanguage;

    public Developer (String name, int age, int salary, String programmingLanguage) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public void displayInfo(){
        System.out.println("Developer: ");
        super.displayInfo();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
