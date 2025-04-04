package com.example.gamified_habit_tracker.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    private Long achievementId;
    private String title;
    private String description;
    private String badge;
    private Long xpRequired;
}
