package homework6;

public class Book {
    String title;
    String author;
    double price;

    public Book (String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void applyDiscount (int discountPercent) {
        double discount = discountPercent / 100.0;
        this.price = this.price * (1 - discount);
    }

    public void printInfo (){
        System.out.println(title + " " + author + " " + price);
    }
}
