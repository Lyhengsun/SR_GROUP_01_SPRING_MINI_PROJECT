package com.example.gamified_habit_tracker.controller;
import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.entity.Profile;
import com.example.gamified_habit_tracker.service.ProfileService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("api/v1/profile")
@RequiredArgsConstructor
@Builder
public class ProfileController {

    private final ProfileService profileService;


    @GetMapping
    public ResponseEntity<ApiResponse<Profile>> getUserProfile(){
        Profile profile = profileService.getUserProfile();
        ApiResponse<Profile> response = new ApiResponse<>(
                "Get an attendee successfully!",
                profile,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
