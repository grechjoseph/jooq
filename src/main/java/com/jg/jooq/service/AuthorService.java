package com.jg.jooq.service;

import com.jg.jooq.data.model.tables.Author;
import com.jg.jooq.dto.AuthorDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private DSLContext context;

    Author author = Author.AUTHOR;

    public AuthorDto createAuthor(String firstName, String lastName) {
        UUID id = UUID.randomUUID();

        context.insertInto(author)
                .set(author.ID, id)
                .set(author.FIRST_NAME, firstName)
                .set(author.LAST_NAME, lastName)
        .execute();

        return getAuthorById(id);
    }

    public AuthorDto getAuthorById(UUID id) {
        return context.select().from(author).where(author.ID.eq(id)).fetchAny().into(AuthorDto.class);
    }

    public List<AuthorDto> getAuthors() {
        return context.select().from(author).fetch().into(AuthorDto.class);
    }

    public AuthorDto updateAuthor(UUID id, String firstName, String lastName) {
        context.update(author)
                .set(author.FIRST_NAME, firstName)
                .set(author.LAST_NAME, lastName)
                .where(author.ID.eq(id))
                .execute();

        return getAuthorById(id);
    }

    public void deleteAuthorById(UUID id) {
        context.delete(author).where(author.ID.eq(id)).execute();
    }
}
