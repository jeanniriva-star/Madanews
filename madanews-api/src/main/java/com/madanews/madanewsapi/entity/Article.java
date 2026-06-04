package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticles;

    @Column(nullable = false, length = 255)
    private String titreArt;

    @Column(columnDefinition = "TEXT")
    private String contenu;

    @Column(length = 500)
    private String image;

    @Column(unique = true)
    private String urlArt;

    @Column(length = 150)
    private String auteur;

    @Column(nullable = false)
    private LocalDateTime datePublicationArt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;
}