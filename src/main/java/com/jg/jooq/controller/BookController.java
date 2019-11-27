package com.jg.jooq.controller;

import com.jg.jooq.data.model.Book;
import com.jg.jooq.service.AuthorService;
import com.jg.jooq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors/{authorId}/books")
    public Book createBook(@PathVariable UUID authorId, @RequestBody Book newBook){
        newBook.setAuthor(authorService.getauthorById(authorId));
        return bookService.createBook(newBook);
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable UUID bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable UUID bookId, @RequestBody Book newBook){
        return bookService.updateBook(bookId, newBook);
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBookById(@PathVariable UUID bookId){
        bookService.deleteBookById(bookId);
        return "Book with ID '" + bookId + "' deleted successfully.";
    }
}
