import React from 'react';

export default function BlogCard({ title, category, readTime, description, tags, link }) {
  return (
    <div className="blog-card">
      <div className="card-header">
        <span className="badge category-badge">{category}</span>
        <span className="read-time">{readTime}</span>
      </div>
      <h3 className="card-title">{title}</h3>
      <p className="card-desc">{description}</p>
      <div className="card-tags">
        {tags && tags.map(tag => (
          <span key={tag} className="tag-pill">#{tag}</span>
        ))}
      </div>
      <div className="card-footer">
        <a href={link} className="read-btn" target="_blank" rel="noopener noreferrer">
          Read Guide <span>&rarr;</span>
        </a>
      </div>
    </div>
  );
}
