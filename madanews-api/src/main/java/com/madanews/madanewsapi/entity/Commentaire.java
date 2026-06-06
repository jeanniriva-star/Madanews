package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "commentaires")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenuCom;

    @Column(nullable = false)
    private LocalDateTime dateCom;

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