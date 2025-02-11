package com.epicode.BlogController.controller;


import com.epicode.BlogController.model.Author;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private List<Author> authors = new ArrayList<>();
    private Long counter = 1L;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authors;
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authors.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        author.setId(counter++);
        authors.add(author);
        return author;
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                author.setNome(updatedAuthor.getNome());
                author.setCognome(updatedAuthor.getCognome());
                author.setEmail(updatedAuthor.getEmail());
                author.setDataDiNascita(updatedAuthor.getDataDiNascita());
                return author;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authors.removeIf(author -> author.getId().equals(id));
    }
}

