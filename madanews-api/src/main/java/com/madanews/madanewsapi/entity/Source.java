package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSources;

    @Column(nullable = false, length = 150)
    private String nomSources;

    @Column(nullable = false, unique = true)
    private String urlSources;

    @Column(length = 255)
    private String descriptionSources;

    @Column(nullable = false)
    private String statutSources;
}