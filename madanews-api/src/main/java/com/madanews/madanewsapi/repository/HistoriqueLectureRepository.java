package com.madanews.madanewsapi.repository;

import com.madanews.madanewsapi.entity.HistoriqueLecture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoriqueLectureRepository
        extends JpaRepository<HistoriqueLecture, Long> {

    List<HistoriqueLecture> findByUtilisateur_IdUtilisateurs(
            Long idUtilisateurs
    );
}