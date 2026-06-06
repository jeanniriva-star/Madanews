package com.madanews.madanewsapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO {

    private Long idUtilisateurs;

    private String nom;

    private String email;

    private String role;

    private String message;
}