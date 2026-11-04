package com.codebytushu.oop.casestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Manages the library's book inventory and search capabilities.
 * 
 * @author CodeByTushu
 */
public class Catalog {
    private final List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    public synchronized void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    public List<Book> searchByTitle(String query) {
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(b -> !b.isIssued())
                .collect(Collectors.toList());
    }

    public void printCatalog() {
        System.out.println("\n📖 --- CURRENT LIBRARY CATALOG ---");
        books.forEach(System.out::println);
    }
}
