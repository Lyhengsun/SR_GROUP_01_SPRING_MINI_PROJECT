package com.example.gamified_habit_tracker.model.dto.request;

import com.example.gamified_habit_tracker.model.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitLogRequest {
    private Status status;
    private UUID habitId;
}
