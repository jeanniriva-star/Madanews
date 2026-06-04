package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historique_lectures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoriqueLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorique;

    @Column(nullable = false)
    private LocalDateTime dateLecture;

    @Column(nullable = false)
    private Integer tempsLecture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_utilisateur",
            nullable = false
    )
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_article",
            nullable = false
    )
    private Article article;
}