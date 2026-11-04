-- ============================================================================
-- CodeByTushu - Complete SQL & Database Guide
-- Script: 01_window_functions.sql
-- Description: Essential Window Functions (ROW_NUMBER, DENSE_RANK, LEAD, LAG, Running Totals)
-- ============================================================================

-- 1. ROW_NUMBER() vs RANK() vs DENSE_RANK() by Product Price per Category
SELECT 
    p.name AS product_name,
    c.name AS category_name,
    p.price,
    ROW_NUMBER() OVER (PARTITION BY p.category_id ORDER BY p.price DESC) AS row_num,
    RANK() OVER (PARTITION BY p.category_id ORDER BY p.price DESC) AS price_rank,
    DENSE_RANK() OVER (PARTITION BY p.category_id ORDER BY p.price DESC) AS dense_price_rank
FROM products p
JOIN categories c ON p.category_id = c.category_id;

-- 2. Running Total of Sales Over Time
SELECT 
    order_id,
    order_date,
    total_amount,
    SUM(total_amount) OVER (ORDER BY order_date ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS running_total_revenue
FROM orders
WHERE status = 'completed';

-- 3. Month-over-Month Revenue Growth using LAG()
WITH MonthlySales AS (
    SELECT 
        DATE_TRUNC('month', order_date) AS sales_month,
        SUM(total_amount) AS monthly_revenue
    FROM orders
    WHERE status = 'completed'
    GROUP BY DATE_TRUNC('month', order_date)
)
SELECT 
    sales_month,
    monthly_revenue,
    LAG(monthly_revenue, 1) OVER (ORDER BY sales_month) AS previous_month_revenue,
    ROUND(
        ((monthly_revenue - LAG(monthly_revenue, 1) OVER (ORDER BY sales_month)) / 
         NULLIF(LAG(monthly_revenue, 1) OVER (ORDER BY sales_month), 0)) * 100, 2
    ) AS mom_growth_percentage
FROM MonthlySales;
