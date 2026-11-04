package com.codebytushu.oop.pillars;

/**
 * Demonstrates Encapsulation in Java.
 * Data hiding using private fields and providing controlled access via getters and setters.
 * 
 * @author CodeByTushu
 * @see <a href="https://codebytushu.com">CodeByTushu Official Platform</a>
 */
public class EncapsulationDemo {

    public static class BankAccount {
        private final String accountNumber;
        private String accountHolder;
        private double balance;

        public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
            if (accountNumber == null || accountNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Account number cannot be empty");
            }
            if (initialBalance < 0) {
                throw new IllegalArgumentException("Initial balance cannot be negative");
            }
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public void setAccountHolder(String accountHolder) {
            if (accountHolder != null && !accountHolder.trim().isEmpty()) {
                this.accountHolder = accountHolder;
            }
        }

        public double getBalance() {
            return balance;
        }

        public synchronized void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }
            this.balance += amount;
            System.out.println("✅ Deposited $" + amount + ". New Balance: $" + this.balance);
        }

        public synchronized boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("❌ Invalid withdrawal amount");
                return false;
            }
            if (amount > this.balance) {
                System.out.println("❌ Insufficient funds! Available: $" + this.balance);
                return false;
            }
            this.balance -= amount;
            System.out.println("✅ Withdrawn $" + amount + ". Remaining Balance: $" + this.balance);
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Encapsulation Demonstration ===");
        BankAccount account = new BankAccount("CBT-10101", "Tushpendra Kumar", 5000.0);
        System.out.println("Account: " + account.getAccountNumber() + " | Holder: " + account.getAccountHolder());
        account.deposit(1500.0);
        account.withdraw(2000.0);
        account.withdraw(6000.0); // Should fail safely
    }
}
