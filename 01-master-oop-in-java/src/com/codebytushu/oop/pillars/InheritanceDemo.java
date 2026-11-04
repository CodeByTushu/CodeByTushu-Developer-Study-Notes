package com.codebytushu.oop.pillars;

/**
 * Demonstrates Inheritance and Method Overriding in Java.
 * Demonstrates IS-A relationship, code reusability, and constructor chaining (super).
 * 
 * @author CodeByTushu
 */
public class InheritanceDemo {

    public static class Vehicle {
        protected String brand;
        protected String model;
        protected int maxSpeed;

        public Vehicle(String brand, String model, int maxSpeed) {
            this.brand = brand;
            this.model = model;
            this.maxSpeed = maxSpeed;
        }

        public void start() {
            System.out.println("Vehicle (" + brand + " " + model + ") starting up...");
        }

        public void displayInfo() {
            System.out.println("Brand: " + brand + " | Model: " + model + " | Max Speed: " + maxSpeed + " km/h");
        }
    }

    public static class ElectricCar extends Vehicle {
        private final int batteryCapacityKWh;
        private int currentChargePercent;

        public ElectricCar(String brand, String model, int maxSpeed, int batteryCapacityKWh) {
            super(brand, model, maxSpeed); // Constructor chaining
            this.batteryCapacityKWh = batteryCapacityKWh;
            this.currentChargePercent = 100;
        }

        @Override
        public void start() {
            System.out.println("ElectricCar (" + brand + " " + model + ") silently powered ON. Battery: " + currentChargePercent + "%");
        }

        public void charge(int amount) {
            this.currentChargePercent = Math.min(100, this.currentChargePercent + amount);
            System.out.println("Battery charged to " + this.currentChargePercent + "%");
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Battery Pack: " + batteryCapacityKWh + " kWh | Charge: " + currentChargePercent + "%");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Inheritance & Polymorphism Demo ===");
        Vehicle generalVehicle = new Vehicle("Generic", "Utility", 120);
        generalVehicle.start();

        ElectricCar tesla = new ElectricCar("Tesla", "Model 3 Performance", 260, 82);
        tesla.start();
        tesla.displayInfo();
    }
}
