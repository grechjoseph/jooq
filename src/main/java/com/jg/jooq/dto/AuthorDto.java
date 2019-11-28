package com.jg.jooq.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthorDto {

    private UUID id;
    private String firstName;
    private String lastName;

}
