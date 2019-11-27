package com.jg.jooq.data.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
public class Book {

    @Id
    private UUID id = UUID.randomUUID();

    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
