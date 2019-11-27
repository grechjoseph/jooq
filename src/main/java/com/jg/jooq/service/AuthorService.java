package com.jg.jooq.service;

import com.jg.jooq.data.model.Author;
import com.jg.jooq.data.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author book){
        return authorRepository.save(book);
    }

    public Author getauthorById(UUID id){
        return authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author with ID '" + id + "' not found."));
    }

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author updateAuthor(UUID id, Author newValues){
        newValues.setId(id);
        return authorRepository.save(newValues);
    }

    public void deleteAuthorById(UUID id){
        authorRepository.delete(getauthorById(id));
    }
}
