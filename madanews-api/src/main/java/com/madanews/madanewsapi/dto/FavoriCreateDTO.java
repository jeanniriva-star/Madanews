package com.madanews.madanewsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriCreateDTO {

    private Long utilisateurId;

    private Long articleId;
}