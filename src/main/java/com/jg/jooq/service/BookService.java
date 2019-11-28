package com.jg.jooq.service;

import com.jg.jooq.data.model.tables.Author;
import com.jg.jooq.data.model.tables.Book;
import com.jg.jooq.dto.BookDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private DSLContext context;

    Book book = Book.BOOK;
    Author author = Author.AUTHOR;

    public BookDto createBook(String name, BigDecimal price, UUID authorId) {
        UUID id = UUID.randomUUID();
        context.insertInto(book)
                .set(book.ID, id)
                .set(book.NAME, name)
                .set(book.PRICE, price)
                .set(book.AUTHOR_ID, authorId)
                .execute();

        return getBookById(id);

    }

    public BookDto getBookById(UUID id) {
        return context.select().from(book).where(book.ID.eq(id)).fetchAny().into(BookDto.class);
    }

    public List<BookDto> getBooks() {
        return context.select().from(book).fetch().into(BookDto.class);
    }

    public List<BookDto> getBooksForAuthor(UUID authorId) {
        return context.select().from(book).where(book.AUTHOR_ID.eq(authorId)).fetch().into(BookDto.class);
    }

    public BookDto updateBook(UUID id, String name, BigDecimal price) {
        context.update(book)
                .set(book.NAME, name)
                .set(book.PRICE, price)
                .execute();

        return getBookById(id);
    }

    public void deleteBookById(UUID id) {
        context.delete(book).where(book.ID.eq(id)).execute();
    }

}
