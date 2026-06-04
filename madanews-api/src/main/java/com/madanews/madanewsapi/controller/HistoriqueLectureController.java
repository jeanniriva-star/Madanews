package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.dto.HistoriqueLectureCreateDTO;
import com.madanews.madanewsapi.entity.HistoriqueLecture;
import com.madanews.madanewsapi.service.HistoriqueLectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historique")
public class HistoriqueLectureController {

    @Autowired
    private HistoriqueLectureService historiqueLectureService;

    @PostMapping
    public HistoriqueLecture enregistrerLecture(
            @RequestBody
            HistoriqueLectureCreateDTO dto
    ) {

        return historiqueLectureService
                .enregistrerLecture(dto);
    }

    @GetMapping("/utilisateur/{id}")
    public List<HistoriqueLecture>
    getHistoriqueUtilisateur(
            @PathVariable Long id
    ) {

        return historiqueLectureService
                .getHistoriqueUtilisateur(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerHistorique(
            @PathVariable Long id
    ) {

        historiqueLectureService
                .supprimerHistorique(id);
    }
}