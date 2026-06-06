package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.dto.CommentaireCreateDTO;
import com.madanews.madanewsapi.entity.Article;
import com.madanews.madanewsapi.entity.Commentaire;
import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private NotificationService notificationService;

    public Commentaire ajouterCommentaire(
            CommentaireCreateDTO dto
    ) {

        Utilisateur utilisateur = utilisateurRepository.findById(
                                dto.getUtilisateurId()
                        )
                        .orElseThrow(() -> new RuntimeException(
                                        "Utilisateur introuvable"));

        Article article = articleRepository.findById(
                                dto.getArticleId()
                        )
                        .orElseThrow(() ->  new RuntimeException(
                                        "Article introuvable"));

        Commentaire commentaire = new Commentaire();
        commentaire.setContenuCom( dto.getContenuCom());
        commentaire.setDateCom(LocalDateTime.now());
        commentaire.setUtilisateur(utilisateur);
        commentaire.setArticle( article);
        Commentaire commentaireSauvegarde = commentaireRepository.save(commentaire);

        notificationService.creerNotification(
                utilisateur,
                "Commentaire",
                "Votre commentaire a été publié."
        );
        return commentaireSauvegarde;
    }

    public List<Commentaire>
    getCommentairesArticle(Long idArticle) {

        return commentaireRepository.findByArticle_IdArticles(idArticle);
    }

    public List<Commentaire>
    getCommentairesUtilisateur(Long idUtilisateur) {

        return commentaireRepository.findByUtilisateur_IdUtilisateurs(idUtilisateur);
    }

    public void supprimerCommentaire(Long idCommentaire ) {

        commentaireRepository.deleteById(idCommentaire);
    }
}