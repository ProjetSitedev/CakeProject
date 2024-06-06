package com.example.site_vitrine.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity (name = "_category")
@Getter @Setter
public class Category {

    @Id @GeneratedValue

    private UUID id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;


}
