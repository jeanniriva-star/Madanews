package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.dto.UtilisateurCreateDTO;
import com.madanews.madanewsapi.dto.UtilisateurResponseDTO;
import com.madanews.madanewsapi.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(
            UtilisateurService utilisateurService
    ) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<UtilisateurResponseDTO>
    getAllUtilisateurs() {

        return utilisateurService
                .getAllUtilisateurs();
    }

    @PostMapping
    public UtilisateurResponseDTO
    createUtilisateur(
            @RequestBody UtilisateurCreateDTO dto
    ) {

        return utilisateurService
                .saveUtilisateur(dto);
    }
}