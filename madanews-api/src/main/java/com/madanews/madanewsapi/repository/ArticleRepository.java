package com.madanews.madanewsapi.repository;

import com.madanews.madanewsapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByCategorie_IdCat(Long idCat);
    List<Article> findByTitreArtContainingIgnoreCase(String titre);
}