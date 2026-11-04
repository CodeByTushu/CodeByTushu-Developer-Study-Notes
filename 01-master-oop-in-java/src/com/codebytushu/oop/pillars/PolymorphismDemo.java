package com.codebytushu.oop.pillars;

/**
 * Demonstrates Runtime Polymorphism (Dynamic Method Dispatch) and Compile-time Polymorphism (Overloading).
 * 
 * @author CodeByTushu
 */
public class PolymorphismDemo {

    public interface PaymentStrategy {
        boolean processPayment(double amount);
        String getPaymentMethodName();
    }

    public static class CreditCardPayment implements PaymentStrategy {
        private final String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public boolean processPayment(double amount) {
            System.out.println("💳 Processing Credit Card payment of $" + amount + " [Card: ****" + cardNumber.substring(Math.max(0, cardNumber.length() - 4)) + "]");
            return true;
        }

        @Override
        public String getPaymentMethodName() {
            return "Credit Card";
        }
    }

    public static class UPIPayment implements PaymentStrategy {
        private final String vpa;

        public UPIPayment(String vpa) {
            this.vpa = vpa;
        }

        @Override
        public boolean processPayment(double amount) {
            System.out.println("⚡ Instant UPI transfer of ₹" + (amount * 85) + " sent via VPA: " + vpa);
            return true;
        }

        @Override
        public String getPaymentMethodName() {
            return "UPI Gateway";
        }
    }

    public static class CheckoutService {
        // Compile-time overloading
        public void checkout(double amount, PaymentStrategy strategy) {
            System.out.println("Starting checkout for $" + amount + " via " + strategy.getPaymentMethodName());
            strategy.processPayment(amount);
        }

        public void checkout(double amount, PaymentStrategy strategy, double discountPercent) {
            double finalAmount = amount - (amount * (discountPercent / 100.0));
            System.out.println("Applying discount of " + discountPercent + "% -> Final Price: $" + finalAmount);
            checkout(finalAmount, strategy);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Polymorphism Demo ===");
        CheckoutService checkout = new CheckoutService();

        PaymentStrategy card = new CreditCardPayment("4111222233334444");
        PaymentStrategy upi = new UPIPayment("codebytushu@upi");

        // Runtime dynamic dispatch
        checkout.checkout(250.0, card);
        checkout.checkout(500.0, upi, 10.0);
    }
}
