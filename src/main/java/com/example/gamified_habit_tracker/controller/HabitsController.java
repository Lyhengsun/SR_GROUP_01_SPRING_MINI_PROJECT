package com.example.gamified_habit_tracker.controller;

import com.example.gamified_habit_tracker.model.entity.Habits;
import com.example.gamified_habit_tracker.model.request.HabitRequest;
import com.example.gamified_habit_tracker.model.response.ApiResponse;
import com.example.gamified_habit_tracker.service.HabitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habits")
public class HabitsController {
    private final HabitService habitService;

    public HabitsController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Habits>>> getAllHabit(@RequestParam(defaultValue = "1") @Positive int page,
                                                                 @RequestParam(defaultValue = "10") @Positive int size) {
        ApiResponse<List<Habits>> response = ApiResponse.<List<Habits>>builder()
                .success(true)
                .message("Get all habits is successfully")
                .status(HttpStatus.OK)
                .payload(habitService.getAllHabit(page, size))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("{habit-id}")
    public ResponseEntity<ApiResponse<Habits>> getHabitById(@Param("habit-id") UUID uuid){
        return ResponseEntity.ok(
                ApiResponse.<Habits>builder()
                        .success(true)
                        .message("Get habit by id is successfully")
                        .status(HttpStatus.OK)
                        .payload(habitService.getHabitById(uuid))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PutMapping("{habit-id}")
    public ResponseEntity<ApiResponse<Habits>> updateHabitById(@Param("habit-id") @Positive UUID uuid, @RequestBody HabitRequest habitRequest){
        return ResponseEntity.ok(
                ApiResponse.<Habits>builder()
                        .success(true)
                        .message("Update habit by id is successfully")
                        .payload(habitService.updateHabitById(uuid,habitRequest))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<Habits>> createHabit(@RequestBody @Valid HabitRequest habitRequest){
        return ResponseEntity.ok(
                ApiResponse.<Habits>builder()
                        .success(true)
                        .message("Post habit is successfully")
                        .payload(habitService.createHabit(habitRequest))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @DeleteMapping("{habit-id}")
    public ResponseEntity<ApiResponse<Habits>> deleteHabitById(@Param("habit-id")@Positive UUID uuid){
        return ResponseEntity.ok(
                ApiResponse.<Habits>builder()
                        .success(true)
                        .message("Delete habit by id is successfully")
                        .payload(habitService.deleteHabitById(uuid))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }


}
