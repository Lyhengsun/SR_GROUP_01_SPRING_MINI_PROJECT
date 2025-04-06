package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.dto.request.HabitRequest;
import com.example.gamified_habit_tracker.model.dto.response.ApiResponse;
import com.example.gamified_habit_tracker.model.entity.Habit;
import com.example.gamified_habit_tracker.service.HabitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("api/v1/habits")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Habit>>> getAllHabits(
            @RequestParam(defaultValue = "1") @Min(value = 1, message = "Page must be greater than or equal to 1") Integer page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "Size must be greater than or equal to 1") Integer size) {
        List<Habit> habits = habitService.getAllHabits(page, size);
        ApiResponse<List<Habit>> response = ApiResponse.<List<Habit>>builder()
                .message("Get all habits successfully!")
                .payload(habits)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<Habit>> getHabitById(@PathVariable("habit_id") UUID habitId) {
        Habit habit = habitService.getHabitById(habitId);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .message("Get a habit successfully!")
                .payload(habit)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Habit>> createHabit(@Valid @RequestBody HabitRequest habitRequest) {
        Habit habit = habitService.createHabit(habitRequest);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .message("Created a habit successfully!")
                .payload(habit)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<Habit>> updateHabit(@PathVariable("habit_id") UUID habitId, @RequestBody HabitRequest habitRequest) {
        Habit habit = habitService.updateHabit(habitId, habitRequest);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .message("Update a habit successfully!")
                .payload(habit)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{habit_id}")
    public ResponseEntity<ApiResponse<Habit>> deleteHabit(@PathVariable("habit_id") UUID habitId) {
        Habit habit = habitService.deleteHabit(habitId);
        ApiResponse<Habit> response = ApiResponse.<Habit>builder()
                .message("Deleted a habit successfully!")
                .payload(habit)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}