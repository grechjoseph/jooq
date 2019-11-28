package com.jg.jooq.controller;

import com.jg.jooq.dto.AuthorDto;
import com.jg.jooq.dto.CreateAuthorDto;
import com.jg.jooq.dto.UpdateAuthorDto;
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
    public AuthorDto createAuthor(@RequestBody CreateAuthorDto author) {
        return authorService.createAuthor(author.getFirstName(), author.getLastName());
    }

    @GetMapping("/authors/{authorId}")
    public AuthorDto getAuthorById(@PathVariable UUID authorId) {
        return authorService.getAuthorById(authorId);
    }

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }

    @PutMapping("/authors/{authorId}")
    public AuthorDto updateAuthor(@PathVariable UUID authorId, @RequestBody UpdateAuthorDto author) {
        return authorService.updateAuthor(authorId, author.getFirstName(), author.getLastName());
    }

    @DeleteMapping("/authors/{authorId}")
    public String deleteAuthorById(@PathVariable UUID authorId) {
        authorService.deleteAuthorById(authorId);
        return "Author with ID '" + authorId + "' deleted successfully.";
    }
}
