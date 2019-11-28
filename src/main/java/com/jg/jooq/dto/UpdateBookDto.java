package com.jg.jooq.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateBookDto {

    private String name;
    private BigDecimal Price;

}
