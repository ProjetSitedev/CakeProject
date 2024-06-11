package com.example.site_vitrine.entities;

<<<<<<< HEAD
=======

>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
import java.util.UUID;

@Entity ( name "_testimony")
@Setter
public class testimonial {

    @Id
    @GeneratedValue
=======
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "_testimony")
@Getter @Setter
public class Testimonial {

    @Id @GeneratedValue

>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
    private UUID id;

    private String author;

    private String content;

<<<<<<< HEAD
    private LocalDateTime CreatedAt = LocalDateTime.now();
}
=======
    private LocalDateTime createdAt = LocalDateTime.now();
}
>>>>>>> 50c0807b0abca31f2f667bd676bfd4e9e882bde6
