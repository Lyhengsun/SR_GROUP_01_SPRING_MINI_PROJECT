package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.dto.request.HabitRequest;
import com.example.gamified_habit_tracker.model.dto.response.HabitResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<HabitResponse> getAllHabits(Integer page, Integer size);

    HabitResponse getHabitById(UUID habitId);

    HabitResponse createHabit(@Valid HabitRequest habitRequest);

    HabitResponse updateHabit(UUID habitId, HabitRequest habitRequest);

    HabitResponse deleteHabit(UUID habitId);
}
