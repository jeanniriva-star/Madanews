package com.madanews.madanewsapi.repository;

import com.madanews.madanewsapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}