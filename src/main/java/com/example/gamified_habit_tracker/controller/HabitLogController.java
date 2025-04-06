package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.entity.HabitLog;
import com.example.gamified_habit_tracker.service.HabitLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/habitlog")
@RequiredArgsConstructor
public class HabitLogController {

    private final HabitLogService habitLogService;

    @GetMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<HabitLog>> getHabitLogByHabitId(@PathVariable("habit_id") UUID habitId) {
        HabitLog habitLog = habitLogService.getHabitLogByHabitId(habitId);
        ApiResponse<HabitLog> response = ApiResponse.<HabitLog>builder()
                .message("Get an achievement by App User Id successfully!")
                .payload(habitLog)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<HabitLog>> createHabitLog(@Valid @RequestBody HabitLogRequest habitLogRequest) {
        HabitLog habitLog = habitLogService.createHabitLog(habitLogRequest);
        ApiResponse<HabitLog> response = ApiResponse.<HabitLog>builder()
                .message("Created a habitlog successfully!")
                .payload(habitLog)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}