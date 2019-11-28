package com.jg.jooq.controller;

import com.jg.jooq.data.model.tables.records.BookRecord;
import com.jg.jooq.dto.ApiBook;
import com.jg.jooq.dto.ApiCreateBook;
import com.jg.jooq.dto.ApiUpdateBook;
import com.jg.jooq.mapper.ModelMapper;
import com.jg.jooq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private ModelMapper mapper = new ModelMapper();

    @PostMapping("/authors/{authorId}/books")
    public ApiBook createBook(@PathVariable UUID authorId, @RequestBody ApiCreateBook book){
        return mapper.map(bookService.createBook(book.getName(), book.getPrice(), authorId), ApiBook.class);
    }

    @GetMapping("/books/{bookId}")
    public ApiBook getBookById(@PathVariable UUID bookId){
        return mapper.map(bookService.getBookById(bookId), ApiBook.class);
    }

    @GetMapping("/books")
    public List<ApiBook> getBooks(){
        return mapper.mapAsList(bookService.getBooks(), ApiBook.class);
    }

    @PutMapping("/books/{bookId}")
    public ApiBook updateBook(@PathVariable UUID bookId, @RequestBody ApiUpdateBook book){
        return mapper.map(bookService.updateBook(bookId, book.getName(), book.getPrice()), ApiBook.class);
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBookById(@PathVariable UUID bookId){
        bookService.deleteBookById(bookId);
        return "Book with ID '" + bookId + "' deleted successfully.";
    }
}
