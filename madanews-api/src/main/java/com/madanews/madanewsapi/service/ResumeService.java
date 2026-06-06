package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.entity.Resume;
import com.madanews.madanewsapi.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Résumé introuvable"));
    }
}