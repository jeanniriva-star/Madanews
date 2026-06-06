package com.madanews.madanewsapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    private String email;

    private String motDePasse;
}