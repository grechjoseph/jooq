package com.jg.jooq.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ApiBook {

    private UUID id;
    private String name;
    private BigDecimal price;

}
