package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.entity.Habits;
import com.example.gamified_habit_tracker.model.request.HabitRequest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface HabitService {
    List<Habits> getAllHabit(int page,int size);

    Habits getHabitById(UUID uuid);

    Habits updateHabitById(UUID uuid,HabitRequest habitRequest);


    Habits deleteHabitById(UUID uuid);

    Habits createHabit(HabitRequest habitRequest);
}
