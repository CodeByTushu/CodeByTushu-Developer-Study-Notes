package com.codebytushu.oop.casestudy;

import java.util.Objects;

/**
 * Represents a Book entity in the Library Management System.
 * 
 * @author CodeByTushu
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean isIssued;

    public Book(String isbn, String title, String author) {
        this.isbn = Objects.requireNonNull(isbn, "ISBN cannot be null");
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
        this.isIssued = false;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public synchronized boolean issueBook() {
        if (isIssued) return false;
        this.isIssued = true;
        return true;
    }

    public synchronized void returnBook() {
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "Book[ISBN=" + isbn + ", Title='" + title + "', Author='" + author + "', Status=" + (isIssued ? "Issued" : "Available") + "]";
    }
}
