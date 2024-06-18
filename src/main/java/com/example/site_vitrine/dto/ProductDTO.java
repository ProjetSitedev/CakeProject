package com.example.site_vitrine.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
public class ProductDTO {
    private UUID id;
    private String name;
    private BigDecimal price;
    private String imageURL;

    public void setPrice(BigDecimal price) {

    }
}
