package com.madanews.madanewsapi.repository;

import com.madanews.madanewsapi.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}