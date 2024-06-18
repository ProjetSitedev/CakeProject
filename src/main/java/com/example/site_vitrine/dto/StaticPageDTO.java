package com.example.site_vitrine.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter @Setter
@ToString
public class StaticPageDTO {
    private UUID id;
    private String title;
    private String content;

    public StaticPageDTO(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
