package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @PostMapping
    public Utilisateur createUtilisateur(
            @RequestBody Utilisateur utilisateur
    ) {
        return utilisateurService.saveUtilisateur(utilisateur);
    }
}