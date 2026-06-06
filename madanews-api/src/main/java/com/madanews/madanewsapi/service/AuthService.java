package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.dto.LoginDTO;
import com.madanews.madanewsapi.dto.LoginResponseDTO;
import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UtilisateurRepository utilisateurRepository;

    public AuthService(
            UtilisateurRepository utilisateurRepository
    ) {
        this.utilisateurRepository =
                utilisateurRepository;
    }

    public LoginResponseDTO login(
            LoginDTO dto
    ) {

        Utilisateur utilisateur =
                utilisateurRepository
                        .findByEmail(
                                dto.getEmail()
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Email introuvable"
                                ));

        if (!utilisateur.getMotDePasse()
                .equals(dto.getMotDePasse())) {

            throw new RuntimeException(
                    "Mot de passe incorrect"
            );
        }

        return LoginResponseDTO.builder()
                .idUtilisateurs(
                        utilisateur.getIdUtilisateurs()
                )
                .nom(
                        utilisateur.getNom()
                )
                .email(
                        utilisateur.getEmail()
                )
                .role(
                        utilisateur.getRole()
                )
                .message(
                        "Connexion réussie"
                )
                .build();
    }
}