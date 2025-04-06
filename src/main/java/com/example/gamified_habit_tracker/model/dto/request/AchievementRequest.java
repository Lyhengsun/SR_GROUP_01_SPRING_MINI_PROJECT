package com.example.gamified_habit_tracker.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String description;


    private String badge;
    private Long xpRequired;
}
