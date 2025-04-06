package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.config.UUIDTypeHandler;
import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.entity.HabitLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitLogRepository {

    // getHabitLogByHabitId
    @Results(id = "habitLogMapper", value = {
            @Result(property = "habitLogId", column = "habit_log_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
            @Result(property = "logDate", column = "log_date"),
            @Result(property = "xpEarned", column = "xp_earned"),
            @Result(property = "habitId", column = "habit_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
    })
    @Select("""
                SELECT *
                FROM habit_logs
                WHERE habit_id = #{habit_id};
            """)
    List<HabitLog> getHabitLogByHabitId(@Param("habit_id") UUID habitId);

    @ResultMap("habitLogMapper")
    @Select("""
            INSERT INTO habit_logs (status, habit_id)
            VALUES (#{req.status}, #{req.habitId})
            RETURNING *;
            """)
    HabitLog createHabitLog(@Param("req") HabitLogRequest habitLogRequest);
}
