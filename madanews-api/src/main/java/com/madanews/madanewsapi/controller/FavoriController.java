package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.dto.FavoriCreateDTO;
import com.madanews.madanewsapi.entity.Favori;
import com.madanews.madanewsapi.service.FavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favoris")
public class FavoriController {

    @Autowired
    private FavoriService favoriService;

    @PostMapping
    public Favori ajouterFavori(
            @RequestBody FavoriCreateDTO dto
    ) {
        return favoriService.ajouterFavori(dto);
    }

    @GetMapping("/utilisateur/{id}")
    public List<Favori> getFavorisUtilisateur(
            @PathVariable Long id
    ) {
        return favoriService.getFavorisUtilisateur(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerFavori(
            @PathVariable Long id
    ) {
        favoriService.supprimerFavori(id);
    }
}
