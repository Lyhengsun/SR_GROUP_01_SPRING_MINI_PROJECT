package com.example.gamified_habit_tracker.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementRequest {
    private String title;
    private String description;
    private String badge;
    private Long xpRequired;
}
