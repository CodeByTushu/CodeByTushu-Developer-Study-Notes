-- ============================================================================
-- CodeByTushu - Complete SQL & Database Guide
-- Script: 02_sample_data_dml.sql
-- Description: Mock Data Population for Analysis and Window Functions
-- ============================================================================

INSERT INTO users (name, email, role) VALUES
('Tushpendra Kumar', 'tushpendra@codebytushu.com', 'admin'),
('Sarah Connor', 'sarah@example.com', 'customer'),
('John Wick', 'john.wick@continental.com', 'customer'),
('Alice Wonderland', 'alice@matrix.io', 'customer'),
('Bruce Wayne', 'bruce@wayne-enterprises.com', 'customer');

INSERT INTO categories (name, description) VALUES
('Electronics', 'Laptops, Monitors, Audio Equipment'),
('Books & Courses', 'Engineering Textbooks, DSA Guides, Online Study Notes'),
('Home & Office', 'Ergonomic Chairs, Desks, Mechanical Keyboards');

INSERT INTO products (category_id, name, price, stock_quantity) VALUES
(1, '4K UHD Developer Monitor 32"', 499.99, 25),
(1, 'Noise Cancelling Wireless Headphones', 199.99, 50),
(2, 'Mastering Java OOP Guide - Print Edition', 39.99, 100),
(2, 'DSA Interview Patterns Handbook', 49.99, 150),
(3, 'Mechanical Keyboard (Cherry MX Brown)', 129.99, 40),
(3, 'Ergonomic Mesh Chair', 349.99, 15);

INSERT INTO orders (user_id, order_date, total_amount, status) VALUES
(2, '2026-01-15 10:30:00', 499.99, 'completed'),
(3, '2026-01-20 14:15:00', 89.98, 'completed'),
(4, '2026-02-05 11:00:00', 629.98, 'completed'),
(2, '2026-02-18 16:45:00', 129.99, 'completed'),
(5, '2026-03-01 09:15:00', 1049.97, 'completed');

INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 499.99),
(2, 3, 1, 39.99),
(2, 4, 1, 49.99),
(3, 1, 1, 499.99),
(3, 5, 1, 129.99),
(4, 5, 1, 129.99),
(5, 1, 1, 499.99),
(5, 6, 1, 349.99),
(5, 2, 1, 199.99);
