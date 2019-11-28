package com.jg.jooq.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApiCreateBook {

    private String name;
    private BigDecimal price;

}
