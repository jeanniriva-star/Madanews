package com.madanews.madanewsapi.repository;

import com.madanews.madanewsapi.entity.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentaireRepository
        extends JpaRepository<Commentaire, Long> {

    List<Commentaire> findByArticle_IdArticles(
            Long idArticles
    );

    List<Commentaire> findByUtilisateur_IdUtilisateurs(
            Long idUtilisateurs
    );
}