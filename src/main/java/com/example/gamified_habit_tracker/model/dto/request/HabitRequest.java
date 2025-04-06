package com.example.gamified_habit_tracker.model.dto.request;

import com.example.gamified_habit_tracker.model.dto.response.AppUserResponse;
import com.example.gamified_habit_tracker.model.entity.Profile;
import com.example.gamified_habit_tracker.model.enumeration.Frequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HabitRequest {
    private String title;
    private String description;
    private Frequency frequency;
}
