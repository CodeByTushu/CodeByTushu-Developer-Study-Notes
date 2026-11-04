package com.codebytushu.oop.casestudy;

/**
 * Represents a Librarian who manages the catalog and inventory.
 * 
 * @author CodeByTushu
 */
public class Librarian extends User {
    private final String staffId;

    public Librarian(String id, String name, String email, String staffId) {
        super(id, name, email);
        this.staffId = staffId;
    }

    public void registerNewBook(Catalog catalog, Book book) {
        catalog.addBook(book);
        System.out.println("📚 Librarian " + name + " (Staff ID: " + staffId + ") added book to catalog: " + book.getTitle());
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n🔑 [Librarian Admin Portal: " + name + " | Staff ID: " + staffId + "]");
    }
}
