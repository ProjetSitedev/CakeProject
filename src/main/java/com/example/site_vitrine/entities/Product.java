package com.example.site_vitrine.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity (name = "_product")
@Getter @Setter
public class Product {

    @Id @GeneratedValue

    private UUID id;

    private String name;

    private double price;

    private String imageURL;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
