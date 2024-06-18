package com.example.site_vitrine.service;

import com.example.site_vitrine.dto.StaticPageDTO;
import com.example.site_vitrine.entities.StaticPage;

import java.util.List;
import java.util.UUID;

public interface StaticService {
    List<StaticPageDTO> getAllStaticPage();

    StaticPageDTO getStaticById(UUID id);

    StaticPage updateStatic(UUID id, StaticPage updatedStatic);

    StaticPageDTO updateStatic(UUID id, StaticPageDTO updatedStatic);

    boolean deleteStatic(UUID id);

    List<StaticPageDTO> searchSatics(String keyword);

    StaticPageDTO findStaticByTitle(String title);

    StaticPage createStaticPage(StaticPage staticPage);

    StaticPageDTO createStaticPage(StaticPageDTO staticPageDTO);
}
