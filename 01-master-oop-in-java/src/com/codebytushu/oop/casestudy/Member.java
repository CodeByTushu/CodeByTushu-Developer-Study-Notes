package com.codebytushu.oop.casestudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Library Member (Student / Faculty).
 * 
 * @author CodeByTushu
 */
public class Member extends User {
    private final List<Book> borrowedBooks;
    private static final int MAX_BORROW_LIMIT = 5;

    public Member(String id, String name, String email) {
        super(id, name, email);
        this.borrowedBooks = new ArrayList<>();
    }

    public synchronized boolean borrowBook(Book book) {
        if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            System.out.println("❌ Member " + name + " reached max borrow limit of " + MAX_BORROW_LIMIT);
            return false;
        }
        if (book.issueBook()) {
            borrowedBooks.add(book);
            System.out.println("✅ Member " + name + " borrowed '" + book.getTitle() + "'");
            return true;
        } else {
            System.out.println("❌ Book '" + book.getTitle() + "' is currently unavailable.");
            return false;
        }
    }

    public synchronized boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println("✅ Member " + name + " returned '" + book.getTitle() + "'");
            return true;
        }
        System.out.println("❌ Member " + name + " does not have this book borrowed.");
        return false;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n👤 [Member Dashboard: " + name + " (" + email + ")]");
        System.out.println("Active Borrowed Books (" + borrowedBooks.size() + "/" + MAX_BORROW_LIMIT + "):");
        borrowedBooks.forEach(b -> System.out.println(" - " + b.getTitle() + " by " + b.getAuthor()));
    }
}
