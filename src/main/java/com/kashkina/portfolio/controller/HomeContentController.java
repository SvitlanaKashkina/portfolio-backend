package com.kashkina.portfolio.controller;

import com.kashkina.portfolio.entity.HomeContent;
import com.kashkina.portfolio.repository.HomeContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeContentController {

    private final HomeContentRepository repository;

    @GetMapping("/home")
    public HomeContent getHomeContent() {
        Optional<HomeContent> content = repository.findById(1L);
        return content.orElse(new HomeContent());
    }
}

