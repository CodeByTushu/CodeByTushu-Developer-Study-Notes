const mongoose = require('mongoose');

const blogPostSchema = new mongoose.Schema(
  {
    title: {
      type: String,
      required: [true, 'Please add a blog title'],
      trim: true,
      maxlength: [150, 'Title cannot exceed 150 characters']
    },
    slug: {
      type: String,
      unique: true
    },
    category: {
      type: String,
      required: true,
      enum: ['Java', 'React', 'DSA', 'Node.js', 'AI', 'SQL', 'General']
    },
    tags: [String],
    readTime: {
      type: String,
      default: '10 Min Read'
    },
    content: {
      type: String,
      required: [true, 'Please add content']
    },
    author: {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'User',
      required: true
    }
  },
  { timestamps: true }
);

module.exports = mongoose.model('BlogPost', blogPostSchema);
