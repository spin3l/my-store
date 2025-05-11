package com.spin3l.store.domain.model.dto;


import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long       id;
    private String     name;
    private String     description;
    private BigDecimal price;
    private BigInteger quantity;
}