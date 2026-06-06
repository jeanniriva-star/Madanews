package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.dto.UtilisateurCreateDTO;
import com.madanews.madanewsapi.dto.UtilisateurResponseDTO;
import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(
            UtilisateurRepository utilisateurRepository
    ) {
        this.utilisateurRepository = utilisateurRepository;
    }

    private UtilisateurResponseDTO convertToDTO(
            Utilisateur utilisateur
    ) {

        return UtilisateurResponseDTO.builder()
                .idUtilisateurs(utilisateur.getIdUtilisateurs())
                .nom(utilisateur.getNom())
                .email(utilisateur.getEmail())
                .role(utilisateur.getRole())
                .build();
    }

    public List<UtilisateurResponseDTO>
    getAllUtilisateurs() {

        return utilisateurRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public UtilisateurResponseDTO saveUtilisateur(
            UtilisateurCreateDTO dto
    ) {

        if (utilisateurRepository
                .findByEmail(dto.getEmail())
                .isPresent()) {

            throw new RuntimeException(
                    "Cet email est déjà utilisé"
            );
        }

        Utilisateur utilisateur =
                new Utilisateur();

        utilisateur.setNom(dto.getNom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMotDePasse(
                dto.getMotDePasse()
        );

        utilisateur.setDateInscription(
                LocalDateTime.now()
        );

        utilisateur.setRole("USER");

        Utilisateur saved =
                utilisateurRepository.save(
                        utilisateur
                );

        return convertToDTO(saved);
    }
}