package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.dto.response.HabitLogReponse;
import com.example.gamified_habit_tracker.service.HabitLogService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("api/v1/habitlog")
@RequiredArgsConstructor
public class HabitLogController {

    private final HabitLogService habitLogService;

    @GetMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<List<HabitLogReponse>>> getHabitLogByHabitId(
            @PathVariable("habit_id") UUID habitId) {
        List<HabitLogReponse> habitLogReponses = habitLogService.getHabitLogByHabitId(habitId);
        ApiResponse<List<HabitLogReponse>> response = ApiResponse.<List<HabitLogReponse>>builder()
                .success(true)
                .message("Get an achievement by App User Id successfully!")
                .payload(habitLogReponses)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<HabitLogReponse>> createHabitLog(
            @Valid @RequestBody HabitLogRequest habitLogRequest) {
        HabitLogReponse habitLog = habitLogService.createHabitLog(habitLogRequest);
        ApiResponse<HabitLogReponse> response = ApiResponse.<HabitLogReponse>builder()
                .success(true)
                .message("Created a habitlog successfully!")
                .payload(habitLog)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}