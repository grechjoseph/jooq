package com.jg.jooq.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBookDto {

    private String name;
    private BigDecimal price;

}
