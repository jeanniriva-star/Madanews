package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.entity.Source;
import com.madanews.madanewsapi.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sources")
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @GetMapping
    public List<Source> getAllSources() {
        return sourceService.getAllSources();
    }

    @PostMapping
    public Source createSource(
            @RequestBody Source source
    ) {
        return sourceService.createSource(source);
    }
}