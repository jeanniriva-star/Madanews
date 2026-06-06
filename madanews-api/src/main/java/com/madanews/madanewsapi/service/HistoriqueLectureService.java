package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.dto.HistoriqueLectureCreateDTO;
import com.madanews.madanewsapi.entity.Article;
import com.madanews.madanewsapi.entity.HistoriqueLecture;
import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.ArticleRepository;
import com.madanews.madanewsapi.repository.HistoriqueLectureRepository;
import com.madanews.madanewsapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoriqueLectureService {

    @Autowired
    private HistoriqueLectureRepository historiqueLectureRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public HistoriqueLecture enregistrerLecture(
            HistoriqueLectureCreateDTO dto
    ) {

        Utilisateur utilisateur = utilisateurRepository
                .findById(dto.getUtilisateurId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Utilisateur introuvable"));

        Article article = articleRepository
                .findById(dto.getArticleId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Article introuvable"));

        HistoriqueLecture historique =
                new HistoriqueLecture();

        historique.setUtilisateur(utilisateur);
        historique.setArticle(article);
        historique.setTempsLecture(dto.getTempsLecture());
        historique.setDateLecture(LocalDateTime.now());

        return historiqueLectureRepository.save( historique);
    }

    public List<HistoriqueLecture> getHistoriqueUtilisateur(
            Long idUtilisateurs
    ) {

        return historiqueLectureRepository.findByUtilisateur_IdUtilisateurs(
                        idUtilisateurs
                );
    }

    public void supprimerHistorique(Long idHistorique
    ) {

        historiqueLectureRepository.deleteById(idHistorique);
    }
}