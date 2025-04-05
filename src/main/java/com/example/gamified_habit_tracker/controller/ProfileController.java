package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.request.ProfileRequest;
import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.entity.Profile;
import com.example.gamified_habit_tracker.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Profile>> getUserProfile() {
        Profile profile = profileService.getUserProfile();
        ApiResponse<Profile> response = ApiResponse.<Profile>builder()
                .message("Successfully get user profile")
                .payload(profile)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Profile>> updateUserProfile(@RequestBody ProfileRequest request) {
        Profile updatedProfile = profileService.updateUserProfile(request);

        ApiResponse<Profile> response = ApiResponse.<Profile>builder()
                .message("Successfully updated user profile")
                .payload(updatedProfile)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ApiResponse<String>deleteUserProfile() {
        profileService.deleteUserProfile();
        return ApiResponse.<String>builder()
                .message("Success").payload(null).status(HttpStatus.OK).timestamp(LocalDateTime.now()).build();
    }



}