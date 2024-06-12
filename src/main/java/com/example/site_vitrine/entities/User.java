package com.example.site_vitrine.entities;


import com.example.site_vitrine.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Getter @Setter
@Table(name = "_user")
public class User {

    @Id @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

    private UserRole userRole;

    private byte[] img;

}
