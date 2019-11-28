package com.jg.jooq.controller;

import com.jg.jooq.data.model.tables.records.AuthorRecord;
import com.jg.jooq.dto.ApiAuthor;
import com.jg.jooq.dto.ApiCreateAuthor;
import com.jg.jooq.dto.ApiUpdateAuthor;
import com.jg.jooq.mapper.ModelMapper;
import com.jg.jooq.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    private ModelMapper mapper = new ModelMapper();

    @PostMapping("/authors")
    public ApiAuthor createAuthor(@RequestBody ApiCreateAuthor author){
        return mapper.map(authorService.createAuthor(author.getFirstName(), author.getLastName()), ApiAuthor.class);
    }

    @GetMapping("/authors/{authorId}")
    public ApiAuthor getAuthorById(@PathVariable UUID authorId){
        return mapper.map(authorService.getAuthorById(authorId), ApiAuthor.class);
    }

    @GetMapping("/authors")
    public List<ApiAuthor> getAuthors(){
        return mapper.mapAsList(authorService.getAuthors(), ApiAuthor.class);
    }

    @PutMapping("/authors/{authorId}")
    public ApiAuthor updateAuthor(@PathVariable UUID authorId, @RequestBody ApiUpdateAuthor author){
        return mapper.map(authorService.updateAuthor(authorId, author.getFirstName(), author.getLastName()), ApiAuthor.class);
    }

    @DeleteMapping("/authors/{authorId}")
    public String deleteAuthorById(@PathVariable UUID authorId){
        authorService.deleteAuthorById(authorId);
        return "Author with ID '" + authorId + "' deleted successfully.";
    }
}
