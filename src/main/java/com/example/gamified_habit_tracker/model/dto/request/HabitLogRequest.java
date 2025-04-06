package com.example.gamified_habit_tracker.model.dto.request;

import com.example.gamified_habit_tracker.model.entity.Habit;
import com.example.gamified_habit_tracker.model.enumeration.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitLogRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private Status status;


    private UUID habitId;
}
