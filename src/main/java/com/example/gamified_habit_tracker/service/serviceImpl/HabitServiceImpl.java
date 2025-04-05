package com.example.gamified_habit_tracker.service.serviceImpl;

import com.example.gamified_habit_tracker.model.entity.Habits;
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
    public List<Habits> getAllHabit(int page,int size) {
        int offset = (page - 1) * size;
        return habitRepository.getAllHabit(offset,size);
    }

    @Override
    public Habits getHabitById(UUID uuid) {
        return habitRepository.getHabitById(uuid);
    }

    @Override
    public Habits updateHabitById(UUID uuid) {
        return habitRepository.updateHabitById();
    }

    @Override
    public Habits createHabit() {
        return habitRepository.createHabit();
    }

    @Override
    public Habits deleteHabitById(UUID uuid) {
        return habitRepository.deleteHabitById(uuid);
    }
}
