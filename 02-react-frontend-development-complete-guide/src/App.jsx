import React, { useState } from 'react';
import Navbar from './components/Navbar';
import BlogCard from './components/BlogCard';
import CounterWithHooks from './components/CounterWithHooks';
import { useDebounce } from './hooks/useDebounce';

const INITIAL_GUIDES = [
  {
    id: 1,
    title: "Master Object-Oriented Programming in Java",
    category: "Java",
    readTime: "8 Min Read",
    description: "Understand the core concepts of OOPs in Java with real-world examples and practical code snippets.",
    tags: ["Backend", "Tips & Tricks"],
    link: "https://codebytushu.com/blogs/blog_details/index.html?id=blog-1"
  },
  {
    id: 2,
    title: "React Frontend Development Complete Guide",
    category: "React",
    readTime: "90 Min Read",
    description: "React hooks completely transformed how we write components. Discover the most essential hooks and architecture patterns.",
    tags: ["Frontend", "React Hooks"],
    link: "https://codebytushu.com/blogs/blog_details/index.html?id=blog-2"
  },
  {
    id: 3,
    title: "Data Structures & Algorithms Interview Guide",
    category: "DSA",
    readTime: "150 Min Read",
    description: "Graphs, Dynamic Programming, and BFS/DFS frequently asked in FAANG interviews.",
    tags: ["Algorithms", "Interview Prep"],
    link: "https://codebytushu.com/blogs/blog_details/index.html?id=blog-3"
  },
  {
    id: 4,
    title: "Node.js Backend Development Guide",
    category: "Node.js",
    readTime: "100 Min Read",
    description: "Step-by-step production RESTful API architecture with Express, MongoDB, and JWT Auth.",
    tags: ["Backend", "Express"],
    link: "https://codebytushu.com/blogs/blog_details/index.html?id=blog-4"
  },
  {
    id: 5,
    title: "Artificial Intelligence Complete Guide",
    category: "AI",
    readTime: "120 Min Read",
    description: "Integrate LLMs, OpenAI API, prompt engineering, and modern neural architectures.",
    tags: ["AI Tools", "GenAI"],
    link: "https://codebytushu.com/blogs/blog_details/index.html?id=blog-5"
  },
  {
    id: 6,
    title: "Complete SQL & Database Guide",
    category: "SQL",
    readTime: "90 Min Read",
    description: "Master SQL Window Functions, query indexing, transactions, and database normalization.",
    tags: ["Database", "SQL"],
    link: "https://codebytushu.com/blogs/blog_details/index.html?id=blog-6"
  }
];

export default function App() {
  const [searchTerm, setSearchTerm] = useState('');
  const [selectedCategory, setSelectedCategory] = useState('All');
  const debouncedSearch = useDebounce(searchTerm, 250);

  const categories = ['All', 'Java', 'React', 'DSA', 'Node.js', 'AI', 'SQL'];

  const filteredGuides = INITIAL_GUIDES.filter(guide => {
    const matchesCategory = selectedCategory === 'All' || guide.category === selectedCategory;
    const matchesSearch = guide.title.toLowerCase().includes(debouncedSearch.toLowerCase()) ||
                          guide.description.toLowerCase().includes(debouncedSearch.toLowerCase());
    return matchesCategory && matchesSearch;
  });

  return (
    <div className="app-layout">
      <Navbar />

      <header className="hero-section">
        <h1 className="hero-title">CodeByTushu React Engineering Hub</h1>
        <p className="hero-subtitle">
          Master React 18+ component architecture, custom hooks, context management, and production UI patterns.
        </p>
      </header>

      <main className="main-content">
        <CounterWithHooks />

        <section className="search-filter-bar">
          <input
            type="text"
            placeholder="🔍 Search technical guides..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="search-input"
          />

          <div className="category-tabs">
            {categories.map(cat => (
              <button
                key={cat}
                onClick={() => setSelectedCategory(cat)}
                className={`category-tab ${selectedCategory === cat ? 'active' : ''}`}
              >
                {cat}
              </button>
            ))}
          </div>
        </section>

        <section className="guides-grid">
          {filteredGuides.map(guide => (
            <BlogCard key={guide.id} {...guide} />
          ))}
        </section>
      </main>

      <footer className="app-footer">
        <p>&copy; 2026 <strong>CodeByTushu</strong>. Building modern engineering ecosystems.</p>
        <p>
          <a href="https://codebytushu.com" target="_blank" rel="noreferrer">Website</a> &bull;{' '}
          <a href="https://youtube.com/@codebytushu" target="_blank" rel="noreferrer">YouTube</a> &bull;{' '}
          <a href="https://github.com/CodeByTushu" target="_blank" rel="noreferrer">GitHub</a>
        </p>
      </footer>
    </div>
  );
}
