package com.madanews.madanewsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleCreateDTO {

    private String titreArt;

    private String contenu;

    private String image;

    private String auteur;

    private Long categorieId;

    private Long sourceId;
}