package com.madanews.madanewsapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurResponseDTO {

    private Long idUtilisateurs;

    private String nom;

    private String email;

    private String role;
}