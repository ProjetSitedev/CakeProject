package com.example.site_vitrine.service;

import com.example.site_vitrine.entities.StaticPage;

import java.util.List;
import java.util.UUID;

public interface StaticService {
    List<StaticPage> getAllStaticPage();

    StaticPage getStaticById(UUID id);

    StaticPage updateStatic(UUID id, StaticPage updatedStatic);

    boolean deleteStatic(UUID id);

    List<StaticPage> searchSatics(String keyword);

    StaticPage findStaticByTitle(String title);

    StaticPage createStaticPage(StaticPage staticPage);
}
