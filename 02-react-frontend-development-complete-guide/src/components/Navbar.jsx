import React from 'react';
import { useTheme } from '../context/ThemeContext';

export default function Navbar() {
  const { theme, toggleTheme } = useTheme();

  return (
    <nav className="cbt-navbar">
      <div className="nav-container">
        <a href="https://codebytushu.com" className="nav-brand">
          <span className="brand-highlight">CodeBy</span>Tushu
        </a>
        <div className="nav-links">
          <a href="https://codebytushu.com" className="nav-link">Home</a>
          <a href="https://codebytushu.com/blogs/index.php#all-blogs" className="nav-link active">All Blogs</a>
          <a href="https://codebytushu.com/Leetcode/" className="nav-link">LeetCode Hub</a>
          <button onClick={toggleTheme} className="theme-toggle-btn" aria-label="Toggle Theme">
            {theme === 'dark' ? '☀️ Light' : '🌙 Dark'}
          </button>
        </div>
      </div>
    </nav>
  );
}
