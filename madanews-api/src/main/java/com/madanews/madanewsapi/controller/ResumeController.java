package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.entity.Resume;
import com.madanews.madanewsapi.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("/{id}")
    public Resume getResumeById(
            @PathVariable Long id
    ) {
        return resumeService.getResumeById(id);
    }
}