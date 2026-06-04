package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.dto.ArticleCreateDTO;
import com.madanews.madanewsapi.entity.Article;
import com.madanews.madanewsapi.entity.Categorie;
import com.madanews.madanewsapi.entity.Resume;
import com.madanews.madanewsapi.entity.Source;
import com.madanews.madanewsapi.repository.ArticleRepository;
import com.madanews.madanewsapi.repository.CategorieRepository;
import com.madanews.madanewsapi.repository.ResumeRepository;
import com.madanews.madanewsapi.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private SourceRepository sourceRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Article introuvable avec l'id : " + id));
    }

    private String genererResume(String contenu) {

        if (contenu == null || contenu.isEmpty()) {
            return "";
        }

        if (contenu.length() <= 300) {
            return contenu;
        }

        return contenu.substring(0, 300) + "...";
    }

    public Article createArticle(ArticleCreateDTO dto) {

        Categorie categorie = categorieRepository.findById(dto.getCategorieId())
                .orElseThrow(() ->
                        new RuntimeException("Categorie introuvable"));

        Source source = sourceRepository.findById(dto.getSourceId())
                .orElseThrow(() ->
                        new RuntimeException("Source introuvable"));

        Article article = new Article();

        article.setTitreArt(dto.getTitreArt());
        article.setContenu(dto.getContenu());
        article.setImage(dto.getImage());
        article.setAuteur(dto.getAuteur());

        article.setCategorie(categorie);
        article.setSource(source);

        article.setDatePublicationArt(LocalDateTime.now());

        Article articleSauvegarde = articleRepository.save(article);

        Resume resume = new Resume();

        resume.setArticle(articleSauvegarde);
        resume.setContenuResumes(
                genererResume(dto.getContenu())
        );
        resume.setDateGeneration(LocalDateTime.now());

        resumeRepository.save(resume);

        return articleSauvegarde;
    }

    public void delete(Long id) {
        articleRepository.deleteById(id);

    }

    public List<Article> getArticlesByCategorie(Long idCat) {

        if (!categorieRepository.existsById(idCat)) {
            throw new RuntimeException("Categorie introuvable");
        }

        return articleRepository.findByCategorie_IdCat(idCat);
    }

    public List<Article> rechercherParTitre(String titre) {

        return articleRepository
                .findByTitreArtContainingIgnoreCase(titre);
    }
}
