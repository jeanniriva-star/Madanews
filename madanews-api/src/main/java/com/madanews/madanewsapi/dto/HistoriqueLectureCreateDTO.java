package com.madanews.madanewsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoriqueLectureCreateDTO {

    private Long utilisateurId;

    private Long articleId;

    private Integer tempsLecture;
}