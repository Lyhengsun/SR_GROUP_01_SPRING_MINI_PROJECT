package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.config.UUIDTypeHandler;
import com.example.gamified_habit_tracker.model.dto.request.HabitLogRequest;
import com.example.gamified_habit_tracker.model.entity.Achievement;
import com.example.gamified_habit_tracker.model.entity.HabitLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.UUID;

@Mapper
public interface HabitLogRepository {


    //getHabitLogByHabitId
    @Results(id="habitLogMapper", value={
            @Result(property = "habitLogId", column = "habit_log_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),

            @Result(property = "logDate", column = "log_date"),
            @Result(property = "xpEarned", column = "xp_earned")
    })
    @Select("""
        SELECT *
        FROM habit_logs hl
        INNER JOIN habits h ON h.habit_id = hl.habit_id
        WHERE hl.habit_log_id = #{habitId};
    """)
    HabitLog getHabitLogByHabitId(@Param("habitId") UUID habitId);


    @ResultMap("habitLogMapper")
    @Select("""
     INSERT INTO habit_logs VALUES (#{req.status}, #{req.habitId})
        RETURNING *;
    """)
    HabitLog createHabitLog(@Param("req") HabitLogRequest habitLogRequest);
}

