package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.dto.PreferenceCreateDTO;
import com.madanews.madanewsapi.entity.Preference;
import com.madanews.madanewsapi.entity.Utilisateur;
import com.madanews.madanewsapi.repository.PreferenceRepository;
import com.madanews.madanewsapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreferenceService {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private   NotificationService notificationService;

    public Preference creerOuModifierPreference(PreferenceCreateDTO dto) {

        Utilisateur utilisateur = utilisateurRepository.findById(
                                dto.getUtilisateurId()
                        )
                        .orElseThrow(() ->
                                new RuntimeException("Utilisateur introuvable"));

        Preference preference = preferenceRepository.findByUtilisateur_IdUtilisateurs(
                                dto.getUtilisateurId()
                        )
                        .orElse(new Preference());

        preference.setThemePrefere(dto.getThemePrefere());
        preference.setLangue(dto.getLangue());
        preference.setUtilisateur( utilisateur);
        Preference preferenceSauvegarde = preferenceRepository.save(preference);

        notificationService.creerNotification(
                utilisateur,
                "Commentaire",
                "Votre commentaire a été publié."
        );

        return preferenceSauvegarde;
    }

    public Preference getPreferenceUtilisateur(
            Long idUtilisateur
    ) {

        return preferenceRepository
                .findByUtilisateur_IdUtilisateurs(
                        idUtilisateur
                )
                .orElseThrow(() -> new RuntimeException( "Préférence introuvable"));
    }

    public void supprimerPreference(Long idPreference ) {

        preferenceRepository.deleteById(idPreference);
    }
}