package com.madanews.madanewsapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResumes;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenuResumes;

    @Column(nullable = false)
    private LocalDateTime dateGeneration;

    @OneToOne
    @JoinColumn(name = "article_id", nullable = false, unique = true)
    private Article article;
}