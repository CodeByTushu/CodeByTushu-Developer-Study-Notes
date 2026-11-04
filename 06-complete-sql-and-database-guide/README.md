# 🗄️ Complete SQL & Database Guide

[![Platform: CodeByTushu](https://img.shields.io/badge/Platform-CodeByTushu-FFC400?style=for-the-badge&logo=codeforces&logoColor=black)](https://codebytushu.com)
[![Topic: SQL & Relational Databases](https://img.shields.io/badge/Database-PostgreSQL_%7C_MySQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)](https://codebytushu.com)
[![Category: Database Engineering](https://img.shields.io/badge/Category-Full_Guide_%26_Source_Code-blue?style=for-the-badge)](https://codebytushu.com/blogs/blog_details/index.html?id=blog-6)

Welcome to the **Complete SQL & Database Guide** repository by **CodeByTushu**! This module contains production DDL/DML schemas for an e-commerce platform and real-world queries demonstrating **SQL Window Functions (`ROW_NUMBER`, `DENSE_RANK`, `LEAD`, `LAG`), CTEs, Indexing, and ACID Transactions**.

---

## 📌 Quick Links
- 🌐 **Read Full Guide on CodeByTushu:** [Complete SQL & Database Guide](https://codebytushu.com/blogs/blog_details/index.html?id=blog-6)
- 📖 **Comprehensive Study Notes (.md):** [StudyNotes.md](./StudyNotes.md)
- 🗄️ **Database Schemas:** [schemas/](./schemas/)
- 🔍 **Optimized Queries:** [queries/](./queries/)

---

## 📁 Repository Structure

```text
06-complete-sql-and-database-guide/
├── schemas/
│   ├── 01_ecommerce_ddl.sql     # 3NF relational schema with Foreign Keys & constraints
│   └── 02_sample_data_dml.sql   # Comprehensive sample dataset for analytical queries
├── queries/
│   ├── 01_window_functions.sql  # ROW_NUMBER, DENSE_RANK, running total, MoM with LAG
│   └── 02_advanced_joins_ctes.sql # CTEs, aggregations, anti-joins
├── StudyNotes.md                # 1,200+ lines in-depth guide on RDBMS, indexing, ACID
└── README.md                    # Documentation
```

---

## 💡 Key SQL Concepts Covered

| Concept | SQL Feature | Real-World Application |
| :--- | :--- | :--- |
| **Window Functions** | `ROW_NUMBER()`, `DENSE_RANK() OVER (PARTITION BY ...)` | Top N products per category |
| **Offset Functions** | `LAG(revenue) OVER (ORDER BY month)` | Month-over-Month (MoM) revenue growth |
| **Running Aggregates**| `SUM(amount) OVER (ORDER BY date)` | Cumulative financial reporting |
| **Common Table Expressions** | `WITH CustomerSpend AS (...)` | Clean, readable complex data pipelines |
| **Relational Integrity**| `FOREIGN KEY ... ON DELETE CASCADE` | Preventing orphaned records in production |

---

## 🌐 Connect with CodeByTushu
- 🌍 **Official Website:** [https://codebytushu.com](https://codebytushu.com)
- 🚀 **Daily LeetCode Hub:** [https://codebytushu.com/Leetcode/](https://codebytushu.com/Leetcode/)
- ▶️ **YouTube Channel:** [@codebytushu](https://www.youtube.com/@codebytushu)
- 📸 **Instagram:** [@codebytushu](https://instagram.com/codebytushu/)
- 💼 **LinkedIn:** [CodeByTushu](https://www.linkedin.com/company/codebytushu/)

---
© 2026 **CodeByTushu**. All rights reserved.
