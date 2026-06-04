package com.madanews.madanewsapi.repository;

import com.madanews.madanewsapi.entity.Favori;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FavoriRepository extends JpaRepository<Favori, Long> {
    List<Favori> findByUtilisateur_IdUtilisateurs(Long idUtilisateurs);
    boolean existsByUtilisateur_IdUtilisateursAndArticle_IdArticles(
            Long idUtilisateurs,
            Long idArticles
    );

}