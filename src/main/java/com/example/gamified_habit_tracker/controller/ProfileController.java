package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.dto.response.AppUserResponse;
import com.example.gamified_habit_tracker.service.AppUserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("api/v1/profile")
@RequiredArgsConstructor
@Builder
public class ProfileController {

    private final AppUserService appUserService;

    @GetMapping
    public ResponseEntity<ApiResponse<AppUserResponse>> getUserProfile() {
        AppUserResponse profile = appUserService.getCurrentUser();
        ApiResponse<AppUserResponse> response = new ApiResponse<>(
                "Get an attendee successfully!",
                profile,
                HttpStatus.OK,
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
