package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.dto.CommentaireCreateDTO;
import com.madanews.madanewsapi.entity.Commentaire;
import com.madanews.madanewsapi.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping
    public Commentaire ajouterCommentaire(
            @RequestBody CommentaireCreateDTO dto
    ) {

        return commentaireService
                .ajouterCommentaire(dto);
    }

    @GetMapping("/article/{id}")
    public List<Commentaire>
    getCommentairesArticle(
            @PathVariable Long id
    ) {

        return commentaireService
                .getCommentairesArticle(id);
    }

    @GetMapping("/utilisateur/{id}")
    public List<Commentaire>
    getCommentairesUtilisateur(
            @PathVariable Long id
    ) {

        return commentaireService
                .getCommentairesUtilisateur(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerCommentaire(
            @PathVariable Long id
    ) {

        commentaireService
                .supprimerCommentaire(id);
    }
}