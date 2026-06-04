package com.madanews.madanewsapi.service;

import com.madanews.madanewsapi.entity.Source;
import com.madanews.madanewsapi.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SourceService {

    @Autowired
    private SourceRepository sourceRepository;

    public List<Source> getAllSources() {
        return sourceRepository.findAll();
    }

    public Source createSource(Source source) {
        return sourceRepository.save(source);
    }

    public Source getSourceById(Long id) {
        return sourceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Source introuvable"));
    }
}