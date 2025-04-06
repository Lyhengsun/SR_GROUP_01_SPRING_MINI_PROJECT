package com.example.gamified_habit_tracker.service.serviceImpl;

import com.example.gamified_habit_tracker.exception.NotFoundException;
import com.example.gamified_habit_tracker.model.entity.Habits;
import com.example.gamified_habit_tracker.model.request.HabitRequest;
import com.example.gamified_habit_tracker.repository.HabitRepository;
import com.example.gamified_habit_tracker.service.HabitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HabitServiceImpl implements HabitService {
    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Override
    public List<Habits> getAllHabit(int page,int size) {
        int offset = (page - 1) * size;
        List<Habits> habits = habitRepository.getAllHabit(offset,size);
        return habits;
    }

    @Override
    public Habits getHabitById(UUID uuid) {
        Habits habits = habitRepository.getHabitById(uuid);
        return habits;
    }

    @Override
    public Habits updateHabitById(UUID uuid,HabitRequest habitRequest) {
        Habits habits = habitRepository.updateHabitById(uuid,habitRequest);
        if (habits.equals(null)){
            throw new NotFoundException("Can not update");
        }
        return habitRepository.updateHabitById(uuid,habitRequest);
    }



    @Override
    public Habits deleteHabitById(UUID uuid) {
        Habits habits = habitRepository.deleteHabitById(uuid);
        return habits;
    }

    @Override
    public Habits createHabit(HabitRequest request) {
        Habits habits = habitRepository.createHabit(request);
        return habits;
    }
}
