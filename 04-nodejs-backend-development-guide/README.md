# 🟢 Node.js Backend Development Guide

[![Platform: CodeByTushu](https://img.shields.io/badge/Platform-CodeByTushu-FFC400?style=for-the-badge&logo=codeforces&logoColor=black)](https://codebytushu.com)
[![Topic: Node.js & Express](https://img.shields.io/badge/Runtime-Node.js_LTS-green?style=for-the-badge&logo=node.js&logoColor=white)](https://codebytushu.com)
[![Category: Backend Architecture](https://img.shields.io/badge/Category-Full_Guide_%26_Source_Code-blue?style=for-the-badge)](https://codebytushu.com/blogs/blog_details/index.html?id=blog-4)

Welcome to the **Node.js Backend Development Guide** repository by **CodeByTushu**! This project contains a production-ready, modular RESTful API architecture built with **Node.js, Express.js, MongoDB (Mongoose), JWT Authentication, and bcryptjs**.

---

## 📌 Quick Links
- 🌐 **Read Full Guide on CodeByTushu:** [Node.js Backend Development Guide](https://codebytushu.com/blogs/blog_details/index.html?id=blog-4)
- 📖 **Comprehensive Study Notes (.md):** [StudyNotes.md](./StudyNotes.md)
- 💻 **Backend Source Code:** [src/](./src/)

---

## 📁 Repository Structure

```text
04-nodejs-backend-development-guide/
├── src/
│   ├── config/
│   │   └── db.js                 # MongoDB connection logic
│   ├── controllers/
│   │   ├── authController.js     # User registration, login & JWT generation
│   │   └── blogController.js     # Blog CRUD, category filter & search
│   ├── middleware/
│   │   ├── authMiddleware.js     # JWT Bearer authentication guard
│   │   └── errorMiddleware.js    # Global error handler with Mongoose error mappings
│   ├── models/
│   │   ├── User.js               # User schema with pre-save bcrypt hashing
│   │   └── BlogPost.js           # Technical blog post schema
│   ├── routes/
│   │   ├── authRoutes.js         # /api/auth routes
│   │   └── blogRoutes.js         # /api/blogs routes
│   └── server.js                 # Express application entry point
├── .env.example                  # Environment variables template
├── package.json                  # Scripts & dependencies
├── StudyNotes.md                 # 2,200+ lines complete backend engineering guide
└── README.md                     # Documentation
```

---

## 🚀 Getting Started

### 1. Install Dependencies
```bash
npm install
```

### 2. Configure Environment Variables
Copy `.env.example` to `.env` and set your MongoDB URI:
```bash
cp .env.example .env
```

### 3. Start Development Server
```bash
npm run dev
```
The server will boot at `http://localhost:5000`.

---

## 🔌 API Endpoints Reference

### Authentication
- `POST /api/auth/register` - Create a new developer account
- `POST /api/auth/login` - Authenticate and receive JWT Bearer token

### Technical Blogs & Guides
- `GET /api/blogs` - Get all guides (supports `?category=Java` and `?search=oop`)
- `POST /api/blogs` - Publish a new guide (Requires Bearer token)

### System Health
- `GET /health` - Health check status and timestamp

---

## 🌐 Connect with CodeByTushu
- 🌍 **Official Website:** [https://codebytushu.com](https://codebytushu.com)
- 🚀 **Daily LeetCode Hub:** [https://codebytushu.com/Leetcode/](https://codebytushu.com/Leetcode/)
- ▶️ **YouTube Channel:** [@codebytushu](https://www.youtube.com/@codebytushu)
- 📸 **Instagram:** [@codebytushu](https://instagram.com/codebytushu/)
- 💼 **LinkedIn:** [CodeByTushu](https://www.linkedin.com/company/codebytushu/)

---
© 2026 **CodeByTushu**. All rights reserved.
