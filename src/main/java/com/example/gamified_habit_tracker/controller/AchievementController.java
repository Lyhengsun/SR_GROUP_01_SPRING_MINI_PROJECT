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
import java.util.UUID;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("api/v1/achievements")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService achievementService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Achievement>>> getAllAchievements(
            @RequestParam(defaultValue = "1") @Min(value = 1, message = "Page must be greater than or equal to 1") Integer page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Size must be greater than or equal to 1") Integer size) {
        List<Achievement> achievements = achievementService.getAllAchievements(page, size);
        ApiResponse<List<Achievement>> response = ApiResponse.<List<Achievement>>builder()
                .message("Get all achievements successfully!")
                .payload(achievements)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    @GetMapping("/{appUserId}")
    public ResponseEntity<ApiResponse<Achievement>> getAchievementByAppUsersId(@PathVariable("appUserId") UUID appUserId) {
        Achievement achievement = achievementService.getAchievementByAppUsersId(appUserId);
        ApiResponse<Achievement> response = ApiResponse.<Achievement>builder()
                .message("Get an achievement by App User Id successfully!")
                .payload(achievement)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}