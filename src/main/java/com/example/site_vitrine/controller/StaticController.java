package com.example.site_vitrine.controller;


import com.example.site_vitrine.entities.StaticPage;
import com.example.site_vitrine.service.StaticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("staticPage")
public class StaticController {

    private final StaticService staticService;

    public StaticController(StaticService staticService) {
        this.staticService = staticService;
    }

    @GetMapping
    public ResponseEntity<List<StaticPage>> getAllStaticPages() {
        List<StaticPage> staticPages = staticService.getAllStaticPage();
        return ResponseEntity.ok(staticPages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaticPage> getStaticPageById(@PathVariable UUID id) {
        return ResponseEntity.ok(staticService.getStaticById(id));
    }

    @PostMapping
    public ResponseEntity<StaticPage> createStaticPage(@RequestBody StaticPage staticPage) {
        StaticPage createdStaticPage = staticService.createStaticPage(staticPage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaticPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaticPage> updateStaticPage(@PathVariable UUID id, @RequestBody StaticPage updatedStaticPage) {
        StaticPage staticPage = staticService.updateStatic(id, updatedStaticPage);
        if (staticPage != null) {
            return ResponseEntity.ok(staticPage);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaticPage(@PathVariable UUID id) {
        boolean deleted = staticService.deleteStatic(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<StaticPage>> searchStaticPage(@RequestParam("keyword") String keyword) {
        List<StaticPage> staticPages = staticService.searchSatics(keyword);
        return ResponseEntity.ok(staticPages);
    }
}
