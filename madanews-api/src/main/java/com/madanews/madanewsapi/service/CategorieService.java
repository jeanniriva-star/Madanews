package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.entity.Categorie;
import com.madanews.madanewsapi.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categorie introuvable"));
    }
}