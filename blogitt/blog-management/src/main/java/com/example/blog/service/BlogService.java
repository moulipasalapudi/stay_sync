package com.example.blog.service;

import com.example.blog.model.BlogPost;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogPost> findAll() {
        return blogRepository.findAll();
    }

    public Optional<BlogPost> findById(Long id) {
        return blogRepository.findById(id);
    }

    public BlogPost save(BlogPost blogPost) {
        return blogRepository.save(blogPost);
    }

    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    public BlogPost update(Long id, BlogPost blogPost) {
        if (blogRepository.existsById(id)) {
            blogPost.setId(id);
            return blogRepository.save(blogPost);
        }
        return null;
    }
}