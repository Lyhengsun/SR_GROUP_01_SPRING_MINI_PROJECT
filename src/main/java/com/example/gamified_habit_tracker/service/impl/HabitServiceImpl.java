package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.exception.NotFoundException;
import com.example.gamified_habit_tracker.mapper.HabitMapper;
import com.example.gamified_habit_tracker.model.dto.request.HabitRequest;
import com.example.gamified_habit_tracker.model.dto.response.HabitResponse;
import com.example.gamified_habit_tracker.model.entity.AppUser;
import com.example.gamified_habit_tracker.model.entity.Habit;
import com.example.gamified_habit_tracker.repository.HabitRepository;
import com.example.gamified_habit_tracker.service.AppUserService;
import com.example.gamified_habit_tracker.service.HabitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class HabitServiceImpl implements HabitService {

    private final HabitRepository habitRepository;
    private final HabitMapper habitMapper;
    private final AppUserService appUserService;

    private UUID getCurrentUserId() {
        AppUser currentAppUser = (AppUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return currentAppUser.getAppUserId();
    }

    private HabitResponse toHabitResponse(Habit habit) {
        HabitResponse habitResponse = habitMapper.toHabitResponse(habit);
        habitResponse.setAppUserResponse(appUserService.getUserById(habit.getAppUserId()));
        return habitResponse;
    }

    @Override
    public List<HabitResponse> getAllHabits(Integer page, Integer size) {
        List<Habit> habits = habitRepository.getAllHabitsByUserId(getCurrentUserId(), page, size);
        List<HabitResponse> habitResponses = habits.stream().map((habit) -> toHabitResponse(habit)).toList();
        return habitResponses;
    }

    @Override
    public HabitResponse getHabitById(UUID habitId) {
        if (habitId == null) {
            throw new IllegalArgumentException("Habit ID cannot be null");
        }
        Habit habit = habitRepository.getHabitById(habitId);
        if (habit == null) {
            throw new NotFoundException("Habit with ID " + habitId + " not found");
        }
        return toHabitResponse(habit);
    }

    @Override
    public HabitResponse createHabit(HabitRequest habitRequest) {
        log.info("HabitRequest " + habitRequest.getTitle());
        log.info("HabitRequest " + habitRequest.getDescription());
        log.info("HabitRequest " + habitRequest.getFrequency().toString());
        Habit habit = habitRepository.createHabit(getCurrentUserId(), habitRequest);
        HabitResponse habitResponse = toHabitResponse(habit);
        return habitResponse;
    }

    @Override
    public HabitResponse updateHabit(UUID habitId, HabitRequest habitRequest) {

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
        HabitResponse habitResponse = toHabitResponse(habitRepository.updateHabit(habitId, habitRequest));
        return habitResponse;
    }

    @Override
    public HabitResponse deleteHabit(UUID habitId) {
        if (habitId == null) {
            throw new IllegalArgumentException("Habit ID cannot be null");
        }
        Habit habit = habitRepository.getHabitById(habitId);
        if (habit == null) {
            throw new NotFoundException("Habit with ID " + habitId + " not found");
        }
        return toHabitResponse(habitRepository.deleteHabit(habitId));
    }
}