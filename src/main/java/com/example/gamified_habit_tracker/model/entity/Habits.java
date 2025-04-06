package com.example.gamified_habit_tracker.model.entity;

import com.example.gamified_habit_tracker.config.Frequency;
import com.example.gamified_habit_tracker.model.response.AppUserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Habits {
    private UUID habitId;
    private String title;
    private String description;
    private Frequency frequency;
    private boolean isActive;
    private AppUserResponse appUserResponse;
    private LocalDateTime createAt;
}