const BlogPost = require('../models/BlogPost');

// @desc    Get all blog posts (with search & category filters)
// @route   GET /api/blogs
const getBlogs = async (req, res, next) => {
  try {
    const { category, search } = req.query;
    let query = {};

    if (category && category !== 'All') {
      query.category = category;
    }

    if (search) {
      query.$or = [
        { title: { $regex: search, $options: 'i' } },
        { content: { $regex: search, $options: 'i' } }
      ];
    }

    const blogs = await BlogPost.find(query).populate('author', 'name email').sort({ createdAt: -1 });
    res.json({ success: true, count: blogs.length, data: blogs });
  } catch (error) {
    next(error);
  }
};

// @desc    Create a new blog post
// @route   POST /api/blogs
const createBlog = async (req, res, next) => {
  try {
    const { title, category, tags, readTime, content } = req.body;
    const blog = await BlogPost.create({
      title,
      category,
      tags,
      readTime,
      content,
      author: req.user._id
    });
    res.status(201).json({ success: true, data: blog });
  } catch (error) {
    next(error);
  }
};

module.exports = { getBlogs, createBlog };
