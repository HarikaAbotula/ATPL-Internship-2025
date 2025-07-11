package com.aaslin.assignments;
import java.util.*;

public class LibraryBookManagement {
	
    Map<String, Set<String>> library = new HashMap<>();

    // Add a book to a genre
    public void addBook(String genre, String bookTitle) {
        library.putIfAbsent(genre, new HashSet<>());
        boolean added = library.get(genre).add(bookTitle);
        
        if (added)
            System.out.println(bookTitle + " added to genre " + genre);
        else
            System.out.println(bookTitle + " already exists in genre " + genre);
    }

    // Remove a book from a genre
    public void removeBook(String genre, String bookTitle) {
        if (!library.containsKey(genre)) {
            System.out.println("Genre " + genre + "not found.");
            return;
        }
        boolean removed = library.get(genre).remove(bookTitle);
        if (removed)
            System.out.println(bookTitle + " removed from genre " + genre);
        else
            System.out.println(bookTitle + " not found in genre " + genre);
    }

    // Search all books in a given genre
    public void searchGenre(String genre) {
        if (!library.containsKey(genre) || library.get(genre).isEmpty()) {
            System.out.println("No books found in genre " + genre);
        } else {
            System.out.println("Books in genre " + genre + " : " + library.get(genre));
        }
    }
    
    public static void main(String[] args) {
        LibraryBookManagement librarybook = new LibraryBookManagement();

        // Add books
        librarybook.addBook("Fiction", "Harry Potter");
        librarybook.addBook("Fiction", "The Hobbit");
        librarybook.addBook("Romance", "Titanic");
        librarybook.addBook("Romance", "My Fault");

        // Search by genre
        librarybook.searchGenre("Fiction");
        librarybook.searchGenre("Romance");

        // Remove a book
        librarybook.removeBook("Fiction", "The Hobbit");

        // Search again after removal
        librarybook.searchGenre("Fiction");
    }
}
