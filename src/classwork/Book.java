package classwork;

import java.util.*;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    // Конструктор
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true; // За замовчуванням книга доступна
    }

    // Метод для виведення інформації про книгу
    public void displayInfo() {
        System.out.println("Назва: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Рік видання: " + year);
        System.out.println("Статус: " + (isAvailable ? "Доступна" : "Видана"));
        System.out.println("-------------------------");
    }

    // Метод для позичення книги
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Книга \"" + title + "\" була позичена.");
        } else {
            System.out.println("Книга \"" + title + "\" вже видана.");
        }
    }

    // Метод для повернення книги
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Книга \"" + title + "\" була повернена.");
        } else {
            System.out.println("Книга \"" + title + "\" вже доступна.");
        }
    }

    // Геттери
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

