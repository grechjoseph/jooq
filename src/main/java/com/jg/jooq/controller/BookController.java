package com.jg.jooq.controller;

import com.jg.jooq.dto.ApiBook;
import com.jg.jooq.dto.ApiCreateBook;
import com.jg.jooq.dto.ApiUpdateBook;
import com.jg.jooq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/authors/{authorId}/books")
    public ApiBook createBook(@PathVariable UUID authorId, @RequestBody ApiCreateBook book){
        return bookService.createBook(book.getName(), book.getPrice(), authorId);
    }

    @GetMapping("/books/{bookId}")
    public ApiBook getBookById(@PathVariable UUID bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books")
    public List<ApiBook> getBooks(){
        return bookService.getBooks();
    }

    @PutMapping("/books/{bookId}")
    public ApiBook updateBook(@PathVariable UUID bookId, @RequestBody ApiUpdateBook book){
        return bookService.updateBook(bookId, book.getName(), book.getPrice());
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBookById(@PathVariable UUID bookId){
        bookService.deleteBookById(bookId);
        return "Book with ID '" + bookId + "' deleted successfully.";
    }
}
