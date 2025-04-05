package com.example.gamified_habit_tracker.model.request;

import com.example.gamified_habit_tracker.model.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitRequest {
    private String title;
    private String description;
    private String frequency;
    private boolean isActive;
    private List<UUID> appUserResponse;
}
