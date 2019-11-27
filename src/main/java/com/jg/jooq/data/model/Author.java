package com.jg.jooq.data.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@ToString(exclude = "books")
public class Author {

    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

}
