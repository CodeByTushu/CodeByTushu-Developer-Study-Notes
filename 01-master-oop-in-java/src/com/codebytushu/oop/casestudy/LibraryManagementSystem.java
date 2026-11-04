package com.codebytushu.oop.casestudy;

/**
 * Main application runner for the Library Management Case Study.
 * Integrates Abstraction, Encapsulation, Inheritance, Polymorphism, and Collections.
 * 
 * @author CodeByTushu
 * @see <a href="https://codebytushu.com">CodeByTushu Official Platform</a>
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   🏛️ CODEBYTUSHU LIBRARY MANAGEMENT SYSTEM     ");
        System.out.println("=================================================");

        // 1. Initialize Catalog
        Catalog catalog = new Catalog();

        // 2. Initialize Staff & Members
        Librarian headLibrarian = new Librarian("LIB-01", "Tushpendra Kumar", "admin@codebytushu.com", "STAFF-902");
        Member memberAlex = new Member("MEM-101", "Alex Smith", "alex@example.com");

        // 3. Register Books via Librarian
        Book book1 = new Book("978-0134685991", "Effective Java (3rd Edition)", "Joshua Bloch");
        Book book2 = new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman");
        Book book3 = new Book("978-0201633610", "Design Patterns: Elements of Reusable Object-Oriented Software", "Gang of Four");

        headLibrarian.registerNewBook(catalog, book1);
        headLibrarian.registerNewBook(catalog, book2);
        headLibrarian.registerNewBook(catalog, book3);

        catalog.printCatalog();

        // 4. Member actions
        System.out.println("\n--- Member Loan Operations ---");
        memberAlex.borrowBook(book1);
        memberAlex.borrowBook(book2);
        
        // Try borrowing already borrowed book
        Member memberPriya = new Member("MEM-102", "Priya Sharma", "priya@example.com");
        memberPriya.borrowBook(book1); // Should report unavailable

        // Display dashboards
        memberAlex.displayDashboard();

        // Return book
        System.out.println("\n--- Member Return Operation ---");
        memberAlex.returnBook(book1);
        
        // Priya can now borrow
        memberPriya.borrowBook(book1);
        memberPriya.displayDashboard();

        System.out.println("\n✅ Case Study successfully demonstrated all OOP principles!");
    }
}
