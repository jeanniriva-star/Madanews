package com.madanews.madanewsapi.repository;

import com.madanews.madanewsapi.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    Optional<Categorie> findByNomCat(String nomCat);

    boolean existsByNomCat(String nomCat);
}