package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.dto.PreferenceCreateDTO;
import com.madanews.madanewsapi.entity.Preference;
import com.madanews.madanewsapi.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @PostMapping
    public Preference creerOuModifierPreference(
            @RequestBody PreferenceCreateDTO dto
    ) {

        return preferenceService
                .creerOuModifierPreference(dto);
    }

    @GetMapping("/utilisateur/{id}")
    public Preference getPreferenceUtilisateur(
            @PathVariable Long id
    ) {

        return preferenceService
                .getPreferenceUtilisateur(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerPreference(
            @PathVariable Long id
    ) {

        preferenceService
                .supprimerPreference(id);
    }
}