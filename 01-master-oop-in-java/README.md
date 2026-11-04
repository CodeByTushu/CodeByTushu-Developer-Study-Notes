# ☕ Master Object-Oriented Programming in Java

[![Platform: CodeByTushu](https://img.shields.io/badge/Platform-CodeByTushu-FFC400?style=for-the-badge&logo=codeforces&logoColor=black)](https://codebytushu.com)
[![Topic: Java OOP](https://img.shields.io/badge/Language-Java_17%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white)](https://codebytushu.com)
[![Category: Engineering Guide](https://img.shields.io/badge/Category-Full_Guide_%26_Source_Code-blue?style=for-the-badge)](https://codebytushu.com/blogs/blog_details/index.html?id=blog-1)

Welcome to the **Master Object-Oriented Programming in Java** module by **CodeByTushu**! This project contains production-grade, clean, runnable Java code samples demonstrating the 4 OOP pillars, SOLID design principles, GoF design patterns, and an end-to-end real-world **Library Management System** case study.

---

## 📌 Quick Links
- 🌐 **Read Full Guide on CodeByTushu:** [Master Object-Oriented Programming in Java](https://codebytushu.com/blogs/blog_details/index.html?id=blog-1)
- 📖 **Comprehensive Study Notes (.md):** [StudyNotes.md](./StudyNotes.md)
- 💻 **Complete Source Code Directory:** [src/com/codebytushu/oop](./src/com/codebytushu/oop)

---

## 📁 Repository Structure

```text
01-master-oop-in-java/
├── src/com/codebytushu/oop/
│   ├── pillars/
│   │   ├── EncapsulationDemo.java       # Private state, accessors, invariant validations
│   │   ├── InheritanceDemo.java         # Superclass / Subclass hierarchy, constructor chaining
│   │   ├── PolymorphismDemo.java        # Method overloading & runtime method dispatch
│   │   └── AbstractionDemo.java         # Abstract contracts & cloud storage abstractions
│   ├── solid/
│   │   └── SolidPrinciplesDemo.java     # S.O.L.I.D principles with clear decoupled interfaces
│   ├── patterns/
│   │   └── DesignPatternsDemo.java      # Singleton (double-check lock), Factory, Builder
│   └── casestudy/
│       ├── Book.java                    # Domain entity with state transitions
│       ├── User.java                    # Base abstract user entity
│       ├── Member.java                  # Borrow limits, active loans, dashboards
│       ├── Librarian.java               # Catalog registration operations
│       ├── Catalog.java                 # Search, filtering with Java Streams
│       └── LibraryManagementSystem.java # Full executable application runner
├── StudyNotes.md                        # Complete 1,800+ lines in-depth guide
└── README.md                            # Documentation and quickstart
```

---

## 🚀 How to Run the Code

### 1. Compile All Java Sources:
```bash
javac -d bin src/com/codebytushu/oop/pillars/*.java src/com/codebytushu/oop/solid/*.java src/com/codebytushu/oop/patterns/*.java src/com/codebytushu/oop/casestudy/*.java
```

### 2. Run the Case Study:
```bash
java -cp bin com.codebytushu.oop.casestudy.LibraryManagementSystem
```

### 3. Run Individual Demonstrations:
```bash
# Encapsulation Demo
java -cp bin com.codebytushu.oop.pillars.EncapsulationDemo

# Polymorphism Strategy Pattern
java -cp bin com.codebytushu.oop.pillars.PolymorphismDemo

# SOLID Principles
java -cp bin com.codebytushu.oop.solid.SolidPrinciplesDemo

# Design Patterns
java -cp bin com.codebytushu.oop.patterns.DesignPatternsDemo
```

---

## 💡 Key Architectural Concepts Covered

| Concept | Key Implementation Detail | Class Example |
| :--- | :--- | :--- |
| **Encapsulation** | Private fields + synchronized balance mutation guards | `EncapsulationDemo.BankAccount` |
| **Inheritance** | Vehicle base class extended by `ElectricCar` with `super()` | `InheritanceDemo.ElectricCar` |
| **Polymorphism** | `PaymentStrategy` interface with Card & UPI dynamic dispatch | `PolymorphismDemo.PaymentStrategy` |
| **Abstraction** | `CloudStorageProvider` abstracting AWS S3 & file IO | `AbstractionDemo.CloudStorageProvider` |
| **SOLID Principles** | SRP, OCP, LSP, ISP, and DIP implemented modularly | `SolidPrinciplesDemo` |
| **Creational Patterns** | Singleton with volatile double-checked locking, Builder & Factory | `DesignPatternsDemo` |
| **Real-World Case Study** | Library Management System with books, users, and catalog streams | `LibraryManagementSystem` |

---

## 🌐 Connect with CodeByTushu
- 🌍 **Official Website:** [https://codebytushu.com](https://codebytushu.com)
- 🚀 **Daily LeetCode Hub:** [https://codebytushu.com/Leetcode/](https://codebytushu.com/Leetcode/)
- ▶️ **YouTube Channel:** [@codebytushu](https://www.youtube.com/@codebytushu)
- 📸 **Instagram:** [@codebytushu](https://instagram.com/codebytushu/)
- 💼 **LinkedIn:** [CodeByTushu](https://www.linkedin.com/company/codebytushu/)

---
© 2026 **CodeByTushu**. Created with passion for developer excellence.
