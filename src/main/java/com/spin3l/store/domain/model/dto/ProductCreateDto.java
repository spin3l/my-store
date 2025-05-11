package com.spin3l.store.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDto {
    private String     name;
    private String     description;
    private BigDecimal price;
    private BigInteger quantity;
}
