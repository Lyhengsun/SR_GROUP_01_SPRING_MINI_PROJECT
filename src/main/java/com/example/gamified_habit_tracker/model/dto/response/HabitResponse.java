package com.example.gamified_habit_tracker.model.dto.response;

import com.example.gamified_habit_tracker.model.enumeration.Frequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitResponse {
    private UUID habitId;
    private String title;
    private String description;
    private Frequency frequency;
    private Boolean isActive;
    private AppUserResponse appUserResponse;
    private LocalDateTime createdAt;
}
