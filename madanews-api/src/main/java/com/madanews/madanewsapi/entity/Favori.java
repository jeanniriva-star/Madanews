package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favoris")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Favori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFavoris;

    @Column(nullable = false)
    private LocalDateTime dateAjoutFav;

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