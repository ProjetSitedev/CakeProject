package com.example.site_vitrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @GetMapping("/")
    public String home() {
        return "index"; // Renvoie le nom de la vue associée à la page d'accueil (index.html, index.jsp, etc.)
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // Renvoie le nom de la vue associée à la page À propos (about.html, about.jsp, etc.)
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // Renvoie le nom de la vue associée à la page de contact (contact.html, contact.jsp, etc.)
    }

    // Ajoutez d'autres méthodes pour gérer d'autres pages statiques si nécessaire
}
