package com.example.site_vitrine.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class UpdateProductDTO {
    private String name;
    private BigDecimal price;
    private String imageURL;

}
