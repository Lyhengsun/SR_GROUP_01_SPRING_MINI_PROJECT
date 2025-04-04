package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.entity.Achievement;
import com.example.gamified_habit_tracker.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService achievementService;
    @GetMapping
    public ResponseEntity<ApiResponse<List<Achievement>>> getAllAchievements(@RequestParam(defaultValue = "1") Integer page,
                                                                             @RequestParam(defaultValue = "10") Integer size){
        List<Achievement> achievements = achievementService.getAllAchievements(page, size);
        ApiResponse<List<Achievement>> response= new ApiResponse<List<Achievement>>(
                "Get all attendee successfully!",
                achievements,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{app_users_id}")
    public ResponseEntity<ApiResponse<Achievement>> getAchievementByAppUsersId(@PathVariable("app_users_id") Long appUsersId){
        Achievement achievement = achievementService.getAchievementByAppUsersId(appUsersId);
        ApiResponse<Achievement> response = new ApiResponse<>(
                "Get an achievement by App User Id successfully!",
                achievement,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
