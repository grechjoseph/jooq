package com.jg.jooq.controller;

import com.jg.jooq.dto.ApiAuthor;
import com.jg.jooq.dto.ApiCreateAuthor;
import com.jg.jooq.dto.ApiUpdateAuthor;
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
    public ApiAuthor createAuthor(@RequestBody ApiCreateAuthor author){
        return authorService.createAuthor(author.getFirstName(), author.getLastName());
    }

    @GetMapping("/authors/{authorId}")
    public ApiAuthor getAuthorById(@PathVariable UUID authorId){
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/authors")
    public List<ApiAuthor> getAuthors(){
        return authorService.getAuthors();
    }

    @PutMapping("/authors/{authorId}")
    public ApiAuthor updateAuthor(@PathVariable UUID authorId, @RequestBody ApiUpdateAuthor author){
        return authorService.updateAuthor(authorId, author.getFirstName(), author.getLastName());
    }

    @DeleteMapping("/authors/{authorId}")
    public String deleteAuthorById(@PathVariable UUID authorId){
        authorService.deleteAuthorById(authorId);
        return "Author with ID '" + authorId + "' deleted successfully.";
    }
}
