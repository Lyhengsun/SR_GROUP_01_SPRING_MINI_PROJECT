package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.exception.NotFoundException;
import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.entity.Achievement;
import com.example.gamified_habit_tracker.model.entity.HabitLog;
import com.example.gamified_habit_tracker.repository.HabitLogRepository;
import com.example.gamified_habit_tracker.repository.HabitRepository;
import com.example.gamified_habit_tracker.service.HabitLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HabitLogServiceImpl implements HabitLogService {
    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    @Override
    public HabitLog getHabitLogByHabitId(UUID habitId) {
        if (habitId == null) {
            throw new IllegalArgumentException("habit ID cannot be null");
        }
        HabitLog habitLog = habitLogRepository.getHabitLogByHabitId(habitId);
        if (habitLog == null) {
            throw new NotFoundException("habit with ID " + habitId + " not found");
        }
        return habitLog;
    }

    @Override
    public HabitLog createHabitLog(HabitLogRequest habitLogRequest) {
        if (habitLogRequest == null) {
            throw new IllegalArgumentException("HabitLog request cannot be null");
        }
        return habitLogRepository.createHabitLog(habitLogRequest);
    }
}
