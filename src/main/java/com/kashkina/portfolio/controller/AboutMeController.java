package com.kashkina.portfolio.controller;

import com.kashkina.portfolio.dto.about.AboutMeResponseDTO;
import com.kashkina.portfolio.service.AboutMeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutMeController {

    private final AboutMeService service;

    @GetMapping
    public AboutMeResponseDTO getAboutMe() {
        return service.getAboutMeContent();
    }
}
