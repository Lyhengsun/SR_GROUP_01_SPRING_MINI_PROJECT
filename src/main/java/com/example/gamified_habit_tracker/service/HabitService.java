package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.dto.request.HabitRequest;
import com.example.gamified_habit_tracker.model.entity.Habit;
import com.example.gamified_habit_tracker.model.entity.HabitLog;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface HabitService {

    List<Habit> getAllHabits(Integer page, Integer size);

    Habit getHabitById(UUID habitId);

    Habit createHabit(@Valid HabitRequest habitRequest);

    Habit updateHabit(UUID habitId, HabitRequest habitRequest);

    Habit deleteHabit(UUID habitId);
}
