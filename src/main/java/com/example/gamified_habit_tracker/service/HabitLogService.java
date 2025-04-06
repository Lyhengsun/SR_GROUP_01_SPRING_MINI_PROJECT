package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.dto.response.HabitLogReponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface HabitLogService {
    List<HabitLogReponse> getHabitLogByHabitId(UUID habitId);

    HabitLogReponse createHabitLog(@Valid HabitLogRequest habitLogRequest);
}
