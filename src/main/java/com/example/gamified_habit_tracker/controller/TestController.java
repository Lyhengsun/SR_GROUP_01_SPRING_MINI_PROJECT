package com.example.gamified_habit_tracker.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gamified_habit_tracker.model.entity.AppUser;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping
    public String test() {
        return "Test";
    }

    @GetMapping("/current-user")
    public Long getCurrentUserId() {
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Long userId = appUser.getAppUserId();
        return userId;
    }
}