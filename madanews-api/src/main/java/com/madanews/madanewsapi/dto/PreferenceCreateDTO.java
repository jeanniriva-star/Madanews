package com.madanews.madanewsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreferenceCreateDTO {

    private String themePrefere;

    private String langue;

    private Long utilisateurId;
}