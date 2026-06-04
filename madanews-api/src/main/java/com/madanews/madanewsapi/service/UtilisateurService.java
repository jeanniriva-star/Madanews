package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
}