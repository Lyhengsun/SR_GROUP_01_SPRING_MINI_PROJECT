package com.example.gamified_habit_tracker.model.dto.request;

import com.example.gamified_habit_tracker.model.enumeration.Frequency;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HabitRequest {
    @NotBlank(message = "title is required")
    private String title;
    private String description;
    private Frequency frequency;
}
