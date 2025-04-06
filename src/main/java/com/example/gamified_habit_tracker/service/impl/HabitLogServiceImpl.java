package com.example.gamified_habit_tracker.service.impl;

import com.example.gamified_habit_tracker.mapper.HabitLogMapper;
import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.dto.response.HabitLogReponse;
import com.example.gamified_habit_tracker.model.entity.AppUser;
import com.example.gamified_habit_tracker.model.entity.HabitLog;
import com.example.gamified_habit_tracker.model.enumeration.Status;
import com.example.gamified_habit_tracker.repository.AppUserRepository;
import com.example.gamified_habit_tracker.repository.HabitLogRepository;
import com.example.gamified_habit_tracker.service.HabitLogService;
import com.example.gamified_habit_tracker.service.HabitService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HabitLogServiceImpl implements HabitLogService {
    private final HabitLogRepository habitLogRepository;
    private final AppUserRepository appUserRepository;
    private final HabitService habitService;
    private final HabitLogMapper habitLogMapper;

    private UUID getCurrentUserId() {
        AppUser currentAppUser = (AppUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return currentAppUser.getAppUserId();
    }

    private HabitLogReponse toHabitLogReponse(HabitLog habitLog) {
        HabitLogReponse habitLogReponse = habitLogMapper.toHabitLogReponse(habitLog);
        habitLogReponse.setHabitResponse(habitService.getHabitById(habitLog.getHabitId()));
        return habitLogReponse;
    }

    @Override
    public List<HabitLogReponse> getHabitLogByHabitId(UUID habitId) {
        if (habitId == null) {
            throw new IllegalArgumentException("habit ID cannot be null");
        }
        List<HabitLog> habitLogs = habitLogRepository.getHabitLogByHabitId(habitId);
        List<HabitLogReponse> habitLogReponses = habitLogs.stream().map(habitLog -> toHabitLogReponse(habitLog))
                .toList();

        return habitLogReponses;
    }

    @Override
    public HabitLogReponse createHabitLog(HabitLogRequest habitLogRequest) {
        if (habitLogRequest == null) {
            throw new IllegalArgumentException("HabitLog request cannot be null");
        }
        HabitLog habitLog = habitLogRepository.createHabitLog(habitLogRequest);
        if (habitLog.getStatus() == Status.COMPLETED) {
            AppUser currentUser = appUserRepository.getUserByUserId(getCurrentUserId());
            Long newXp = currentUser.getXp() + habitLog.getXpEarned();
            Long newLevel = newXp / 100;
            appUserRepository.updateUserLevel(getCurrentUserId(), newLevel, newXp);
        }
        return toHabitLogReponse(habitLog);
    }
}
