package com.epicode.BlogController.controller;

import com.epicode.BlogController.model.BlogPost;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {

    private List<BlogPost> blogPosts = new ArrayList<>();
    private Long counter = 1L;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPosts;
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPosts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        blogPost.setId(counter++);
        blogPosts.add(blogPost);
        return blogPost;
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedPost) {
        for (BlogPost post : blogPosts) {
            if (post.getId().equals(id)) {
                post.setCategoria(updatedPost.getCategoria());
                post.setTitolo(updatedPost.getTitolo());
                post.setContenuto(updatedPost.getContenuto());
                post.setTempoDiLettura(updatedPost.getTempoDiLettura());
                return post;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable Long id) {
        blogPosts.removeIf(post -> post.getId().equals(id));
    }
}

