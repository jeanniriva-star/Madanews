package com.madanews.madanewsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentaireCreateDTO {

    private String contenuCom;

    private Long utilisateurId;

    private Long articleId;
}