package com.madanews.madanewsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtilisateurCreateDTO {

    private String nom;

    private String email;

    private String motDePasse;
}