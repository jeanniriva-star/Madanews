package com.madanews.madanewsapi.controller;

import com.madanews.madanewsapi.dto.LoginDTO;
import com.madanews.madanewsapi.dto.LoginResponseDTO;
import com.madanews.madanewsapi.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService
    ) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody LoginDTO dto
    ) {

        return authService.login(dto);
    }
}