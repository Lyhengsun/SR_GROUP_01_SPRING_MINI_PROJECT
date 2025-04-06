package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.exception.NotFoundException;
import com.example.gamified_habit_tracker.model.dto.request.HabitRequest;
import com.example.gamified_habit_tracker.model.entity.Habit;
import com.example.gamified_habit_tracker.repository.HabitRepository;
import com.example.gamified_habit_tracker.service.HabitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;

    @Override
    public List<Habit> getAllHabits(Integer page, Integer size) {
        List<Habit> habits = habitRepository.getAllHabits(page, size);
        if (habits == null || habits.isEmpty()) {
            throw new NotFoundException("No habits found");
        }
        return habits;
    }

    @Override
    public Habit getHabitById(UUID habitId) {
        if (habitId == null) {
            throw new IllegalArgumentException("Habit ID cannot be null");
        }
        Habit habit = habitRepository.getHabitById(habitId);
        if (habit == null) {
            throw new NotFoundException("Habit with ID " + habitId + " not found");
        }
        return habit;
    }

    @Override
    public Habit createHabit(HabitRequest habitRequest) {
        if (habitRequest == null) {
            throw new IllegalArgumentException("Habit request cannot be null");
        }
        return habitRepository.createHabit(habitRequest);
    }

    @Override
    public Habit updateHabit(UUID habitId, HabitRequest habitRequest) {
        if (habitId == null) {
            throw new IllegalArgumentException("Habit ID cannot be null");
        }
        if (habitRequest == null) {
            throw new IllegalArgumentException("Habit request cannot be null");
        }
        Habit existingHabit = habitRepository.getHabitById(habitId);
        if (existingHabit == null) {
            throw new NotFoundException("Habit with ID " + habitId + " not found");
        }
        return habitRepository.updateHabit(habitId, habitRequest);
    }

    @Override
    public Habit deleteHabit(UUID habitId) {
        if (habitId == null) {
            throw new IllegalArgumentException("Habit ID cannot be null");
        }
        Habit habit = habitRepository.getHabitById(habitId);
        if (habit == null) {
            throw new NotFoundException("Habit with ID " + habitId + " not found");
        }
        return habitRepository.deleteHabit(habitId);
    }
}