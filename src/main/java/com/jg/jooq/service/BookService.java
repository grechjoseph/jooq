package com.jg.jooq.service;

import com.jg.jooq.data.model.Book;
import com.jg.jooq.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book getBookById(UUID id){
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book with ID '" + id + "' not found."));
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book updateBook(UUID id, Book newValues){
        newValues.setId(id);
        return bookRepository.save(newValues);
    }

    public void deleteBookById(UUID id){
        bookRepository.delete(getBookById(id));
    }
}
