package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.request.HabitRequest;
import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.dto.response.HabitResponse;
import com.example.gamified_habit_tracker.service.HabitService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import jakarta.validation.constraints.Min;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("api/v1/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<HabitResponse>>> getAllHabits(
            @RequestParam(defaultValue = "1") @Min(value = 1, message = "Page must be greater than or equal to 1") Integer page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Size must be greater than or equal to 1") Integer size) {
        List<HabitResponse> habits = habitService.getAllHabits(page, size);
        ApiResponse<List<HabitResponse>> response = ApiResponse.<List<HabitResponse>>builder()
                .success(true)
                .message("Get all habits successfully!")
                .payload(habits)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<HabitResponse>> getHabitById(
            @PathVariable("habit_id") UUID habitId) {
        HabitResponse habit = habitService.getHabitById(habitId);
        ApiResponse<HabitResponse> response = ApiResponse.<HabitResponse>builder()
                .success(true)
                .message("Get a habit successfully!")
                .payload(habit)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<HabitResponse>> createHabit(@Valid @RequestBody HabitRequest habitRequest) {
        HabitResponse habit = habitService.createHabit(habitRequest);
        ApiResponse<HabitResponse> response = ApiResponse.<HabitResponse>builder()
                .success(true)
                .message("Created a habit successfully!")
                .payload(habit)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<HabitResponse>> updateHabit(@PathVariable("habit_id") UUID habitId,
            @Valid @RequestBody HabitRequest habitRequest) {
        HabitResponse habit = habitService.updateHabit(habitId, habitRequest);
        ApiResponse<HabitResponse> response = ApiResponse.<HabitResponse>builder()
                .message("Update a habit successfully!")
                .payload(habit)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<HabitResponse>> deleteHabit(@PathVariable("habit_id") UUID habitId) {
        HabitResponse habit = habitService.deleteHabit(habitId);
        ApiResponse<HabitResponse> response = ApiResponse.<HabitResponse>builder()
                .message("Deleted a habit successfully!")
                .payload(habit)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}