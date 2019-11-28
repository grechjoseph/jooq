package com.jg.jooq.service;

import com.jg.jooq.data.model.tables.Book;
import com.jg.jooq.data.model.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private DSLContext context;

    com.jg.jooq.data.model.tables.Author author = com.jg.jooq.data.model.tables.Author.AUTHOR;

    public AuthorRecord createAuthor(String firstName, String lastName){
        UUID id = UUID.randomUUID();

        context.insertInto(author)
                .set(author.ID, id)
                .set(author.FIRST_NAME, firstName)
                .set(author.LAST_NAME, lastName)
        .execute();

        return getAuthorById(id);
    }

    public AuthorRecord getAuthorById(UUID id){
        return context.selectFrom(author).where(author.ID.eq(id)).fetchAny();
    }

    public List<AuthorRecord> getAuthors(){
        return context.selectFrom(author).fetch();
    }

    public AuthorRecord updateAuthor(UUID id, String firstName, String lastName){
        context.update(author)
                .set(author.FIRST_NAME, firstName)
                .set(author.LAST_NAME, lastName)
                .where(author.ID.eq(id))
                .execute();

        return getAuthorById(id);
    }

    public void deleteAuthorById(UUID id){
        context.delete(author).where(author.ID.eq(id)).execute();
    }
}
