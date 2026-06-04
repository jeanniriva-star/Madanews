package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.entity.Article;
import com.madanews.madanewsapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.madanews.madanewsapi.dto.ArticleCreateDTO;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {

        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/categorie/{idCat}")
    public List<Article> getArticlesByCategorie(
            @PathVariable Long idCat
    ) {
        return articleService.getArticlesByCategorie(idCat);
    }

    @GetMapping("/recherche")
    public List<Article> rechercherParTitre(
            @RequestParam String titre
    ) {
        return articleService.rechercherParTitre(titre);
    }

    @PostMapping
    public Article createArticle(
            @RequestBody ArticleCreateDTO dto
    ) {
        return articleService.createArticle(dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}