-- ============================================================================
-- CodeByTushu - Complete SQL & Database Guide
-- Script: 02_advanced_joins_ctes.sql
-- Description: Common Table Expressions (CTEs), Recursive CTEs, Aggregations
-- ============================================================================

-- 1. Top 3 Spending Customers using CTE & Aggregations
WITH CustomerSpend AS (
    SELECT 
        u.user_id,
        u.name,
        u.email,
        COUNT(o.order_id) AS total_orders,
        SUM(o.total_amount) AS total_spent
    FROM users u
    JOIN orders o ON u.user_id = o.user_id
    WHERE o.status = 'completed'
    GROUP BY u.user_id, u.name, u.email
)
SELECT 
    name,
    email,
    total_orders,
    total_spent
FROM CustomerSpend
ORDER BY total_spent DESC
LIMIT 3;

-- 2. Identify Products that have NEVER been ordered (LEFT JOIN / IS NULL)
SELECT 
    p.product_id,
    p.name,
    p.price,
    p.stock_quantity
FROM products p
LEFT JOIN order_items oi ON p.product_id = oi.product_id
WHERE oi.order_item_id IS NULL;
