package classwork;

import java.util.ArrayList;
import java.util.List;

public class LibraryUtils {
    public static int countAvailableBooks(ArrayList<Book> books) {
        int availableBooks = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable()) {
                availableBooks++;
            }
        }
        return availableBooks;
    }

    public static List<Book> findBooksByAuthor(List<Book> books, String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().equals(author)) {
                booksByAuthor.add(books.get(i));
            }
        }
        return booksByAuthor;
    }

    public static Book[] sortByYear(List<Book> books) {
        Book[] sortedBooks = new Book[books.size()];
        Book[] books1 = new Book[books.size()];
        for (int i = 0; i < books.size(); i++) {
            books1[i] = books.get(i);
        }
            for (int i = 0; i < books.size(); i ++) {
                int minYear = books1[i].getYear();
                int minYearIndex = 0;
                for (int j = i + 1; j < books.size(); j++) {
                    if (books1[j].getYear() < minYear) {
                        minYear = books1[j].getYear();
                        minYearIndex = j;
                    }
                }sortedBooks[i] = books1[minYearIndex];
                books1[minYearIndex] = books1[i];
                sortedBooks[books.size() -1 ] = books1[i];
            }
    return sortedBooks;
    }
}
