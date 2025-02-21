package homework6;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("the best book", "me", 1000.0);
        Book book2 = new Book("the best book2", "me", 1500.0);
        Book book3 = new Book("the best book3", "me", 1200.0);
        book1.applyDiscount(10);
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();

        Circle circle1 = new Circle(5);
        circle1.calculateArea();
        circle1.calculateCircumference();
        circle1.printInfo();
    }
}
