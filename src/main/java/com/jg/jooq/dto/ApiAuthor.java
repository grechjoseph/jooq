package com.jg.jooq.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ApiAuthor {

    private UUID id;
    private String firstName;
    private String lastName;

}
