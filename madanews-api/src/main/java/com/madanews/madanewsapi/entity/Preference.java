package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "preferences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPreference;

    @Column(nullable = false, length = 100)
    private String themePrefere;

    @Column(nullable = false, length = 50)
    private String langue;

    @OneToOne
    @JoinColumn(
            name = "id_utilisateur",
            nullable = false,
            unique = true
    )
    private Utilisateur utilisateur;
}