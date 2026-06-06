package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.dto.FavoriCreateDTO;
import com.madanews.madanewsapi.entity.Article;
import com.madanews.madanewsapi.entity.Favori;
import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.ArticleRepository;
import com.madanews.madanewsapi.repository.FavoriRepository;
import com.madanews.madanewsapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FavoriService {

    @Autowired
    private FavoriRepository favoriRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private NotificationService notificationService;



    public Favori ajouterFavori(FavoriCreateDTO dto) {

        if (favoriRepository.existsByUtilisateur_IdUtilisateursAndArticle_IdArticles(
                dto.getUtilisateurId(),
                dto.getArticleId())) {

            throw new RuntimeException(
                    "Cet article est déjà dans les favoris"
            );
        }

        Utilisateur utilisateur = utilisateurRepository
                .findById(dto.getUtilisateurId())
                .orElseThrow(() ->
                        new RuntimeException("Utilisateur introuvable"));

        Article article = articleRepository
                .findById(dto.getArticleId())
                .orElseThrow(() ->
                        new RuntimeException("Article introuvable"));

        Favori favori = new Favori();

        favori.setUtilisateur(utilisateur);
        favori.setArticle(article);
        favori.setDateAjoutFav(LocalDateTime.now());

        Favori favoriSauvegarde =
                favoriRepository.save(favori);

        notificationService.creerNotification(
                utilisateur,
                "Favori",
                "Article ajouté aux favoris avec succès."
        );

        return favoriSauvegarde;
    }

    public List<Favori> getFavorisUtilisateur(Long idUtilisateur) {
        return favoriRepository.findByUtilisateur_IdUtilisateurs(idUtilisateur);
    }

    public void supprimerFavori(Long idFavori) {
        favoriRepository.deleteById(idFavori);
    }
}