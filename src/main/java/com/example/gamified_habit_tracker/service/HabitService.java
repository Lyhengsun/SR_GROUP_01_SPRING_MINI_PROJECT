package com.example.gamified_habit_tracker.service;

import com.example.gamified_habit_tracker.model.entity.Habits;

import java.util.List;
import java.util.UUID;

public interface HabitService {
    List<Habits> getAllHabit(int page,int size);

    Habits getHabitById(UUID uuid);

    Habits updateHabitById(UUID uuid);

    Habits createHabit();

    Habits deleteHabitById(UUID uuid);
}
