package classwork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Створення списку книг
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("1984", "Джордж Орвелл", 1949));
        books.add(new Book("Майстер і Маргарита", "Михайло Булгаков", 1967));
        books.add(new Book("Колгосп тварин", "Джордж Орвелл", 1945));
        books.add(new Book("Преступление и наказание", "Федор Достоевский", 1866));

        // Виведення початкової інформації про книги
        System.out.println("=== Початковий стан книг ===");
        for (Book book : books) {
            book.displayInfo();
        }

        // Позичаємо книгу
        System.out.println(">>> Позичаємо книгу: " + books.get(0).getTitle());
        books.get(0).borrowBook();

        // Позичаємо ще одну книгу
        System.out.println(">>> Позичаємо книгу: " + books.get(1).getTitle());
        books.get(1).borrowBook();

        // Виведення оновленого стану книг
        System.out.println("=== Стан книг після позичання ===");
        for (Book book : books) {
            book.displayInfo();
        }

        // Підрахунок доступних книг
        int availableBooks = LibraryUtils.countAvailableBooks(books);
        System.out.println(">>> Кількість доступних книг: " + availableBooks);

        // Пошук книг за автором
        String searchAuthor = "Джордж Орвелл";
        List<Book> foundBooks = LibraryUtils.findBooksByAuthor(books, searchAuthor);
        System.out.println(">>> Книги автора " + searchAuthor + ":");
        for (Book book : foundBooks) {
            book.displayInfo();
        }

        System.out.println(">>> Сортуємо книги за роком видання (від новіших до старіших):");
        Book[] sortedBooks = LibraryUtils.sortByYear(books);
        for (Book book : sortedBooks) {
            book.displayInfo();
        }
    }
}

