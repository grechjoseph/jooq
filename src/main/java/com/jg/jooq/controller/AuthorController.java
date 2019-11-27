package com.jg.jooq.controller;

import com.jg.jooq.data.model.Author;
import com.jg.jooq.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author newAuthor){
        return authorService.createAuthor(newAuthor);
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable UUID authorId){
        return authorService.getauthorById(authorId);
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PutMapping("/authors/{authorId}")
    public Author updateAuthor(@PathVariable UUID authorId, @RequestBody Author newAuthor){
        return authorService.updateAuthor(authorId, newAuthor);
    }

    @DeleteMapping("/authors/{authorId}")
    public String deleteAuthorById(@PathVariable UUID authorId){
        authorService.deleteAuthorById(authorId);
        return "Author with ID '" + authorId + "' deleted successfully.";
    }
}
