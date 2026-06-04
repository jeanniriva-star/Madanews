package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.entity.Categorie;
import com.madanews.madanewsapi.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @PostMapping
    public Categorie createCategorie(
            @RequestBody Categorie categorie
    ) {
        return categorieService.createCategorie(categorie);
    }
}