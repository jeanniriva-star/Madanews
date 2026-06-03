package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @Column(nullable = false, unique = true, length = 100)
    private String nomCat;

    @Column(length = 255)
    private String descriptionCat;
}