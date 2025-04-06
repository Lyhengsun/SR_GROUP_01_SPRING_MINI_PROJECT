package com.example.gamified_habit_tracker.service;


import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.entity.HabitLog;
import jakarta.validation.Valid;

import java.util.UUID;

public interface HabitLogService {
    HabitLog getHabitLogByHabitId(UUID habitId);

    HabitLog createHabitLog(@Valid HabitLogRequest habitLogRequest);
}
