package com.jg.jooq.controller;

import com.jg.jooq.dto.BookDto;
import com.jg.jooq.dto.CreateBookDto;
import com.jg.jooq.dto.UpdateBookDto;
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
    public BookDto createBook(@PathVariable UUID authorId, @RequestBody CreateBookDto book) {
        return bookService.createBook(book.getName(), book.getPrice(), authorId);
    }

    @GetMapping("/books/{bookId}")
    public BookDto getBookById(@PathVariable UUID bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/books")
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/authors/{authorId}/books")
    public List<BookDto> getBooksForAuthor(@PathVariable UUID authorId) {
        return bookService.getBooksForAuthor(authorId);
    }

    @PutMapping("/books/{bookId}")
    public BookDto updateBook(@PathVariable UUID bookId, @RequestBody UpdateBookDto book) {
        return bookService.updateBook(bookId, book.getName(), book.getPrice());
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBookById(@PathVariable UUID bookId) {
        bookService.deleteBookById(bookId);
        return "Book with ID '" + bookId + "' deleted successfully.";
    }
}
