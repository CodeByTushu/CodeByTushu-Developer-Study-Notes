package com.codebytushu.oop.solid;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates SOLID Principles in Java.
 * S - Single Responsibility Principle (SRP)
 * O - Open/Closed Principle (OCP)
 * L - Liskov Substitution Principle (LSP)
 * I - Interface Segregation Principle (ISP)
 * D - Dependency Inversion Principle (DIP)
 * 
 * @author CodeByTushu
 */
public class SolidPrinciplesDemo {

    // 1. Single Responsibility Principle (SRP)
    public static class Invoice {
        private final String id;
        private final double amount;

        public Invoice(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public String getId() { return id; }
        public double getAmount() { return amount; }
    }

    // Separate responsibility: Printing/Rendering
    public static class InvoicePrinter {
        public void print(Invoice invoice) {
            System.out.println("📄 [Invoice " + invoice.getId() + "] Total Due: $" + invoice.getAmount());
        }
    }

    // 2. Open/Closed Principle (OCP)
    public interface DiscountPolicy {
        double calculateDiscount(double price);
    }

    public static class StudentDiscount implements DiscountPolicy {
        @Override
        public double calculateDiscount(double price) {
            return price * 0.20; // 20% off
        }
    }

    public static class FestivalDiscount implements DiscountPolicy {
        @Override
        public double calculateDiscount(double price) {
            return price * 0.15; // 15% off
        }
    }

    // 3. Liskov Substitution Principle (LSP)
    public interface Bird {
        void eat();
    }

    public interface FlyingBird extends Bird {
        void fly();
    }

    public static class Sparrow implements FlyingBird {
        @Override public void eat() { System.out.println("Sparrow eating seeds."); }
        @Override public void fly() { System.out.println("Sparrow flying across sky."); }
    }

    public static class Penguin implements Bird {
        @Override public void eat() { System.out.println("Penguin eating fish."); }
    }

    // 4. Interface Segregation Principle (ISP)
    public interface Workable { void work(); }
    public interface Feedable { void eat(); }

    public static class HumanWorker implements Workable, Feedable {
        @Override public void work() { System.out.println("Human working on code..."); }
        @Override public void eat() { System.out.println("Human enjoying lunch."); }
    }

    public static class RobotWorker implements Workable {
        @Override public void work() { System.out.println("Robot processing automated tasks..."); }
    }

    // 5. Dependency Inversion Principle (DIP)
    public interface NotificationChannel {
        void send(String message);
    }

    public static class EmailChannel implements NotificationChannel {
        @Override public void send(String message) { System.out.println("📧 Email: " + message); }
    }

    public static class AlertSystem {
        private final NotificationChannel channel; // Depend on abstraction

        public AlertSystem(NotificationChannel channel) {
            this.channel = channel;
        }

        public void triggerAlert(String alertText) {
            channel.send("[CRITICAL ALERT] " + alertText);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SOLID Principles in Action ===");
        Invoice inv = new Invoice("INV-2026-001", 1250.0);
        new InvoicePrinter().print(inv);

        DiscountPolicy discount = new StudentDiscount();
        System.out.println("Student Discount on $1250: $" + discount.calculateDiscount(1250.0));

        AlertSystem system = new AlertSystem(new EmailChannel());
        system.triggerAlert("High CPU usage detected on server cluster.");
    }
}
