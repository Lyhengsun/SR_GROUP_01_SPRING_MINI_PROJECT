package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.config.UUIDTypeHandler;
import com.example.gamified_habit_tracker.model.entity.Achievement;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AchievementRepository {

    @Results(id = "achievementMapper", value = {
            @Result(property = "achievementId", column = "achievement_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
            @Result(property = "frequency", column = "frequency"),
            @Result(property = "xpRequired", column = "xp_required"),
            // @Result(property = "profile", column = "app_user_id", one = @One(select =
            // "com.example.gamified_habit_tracker.repository.AppUserRepository.getAppUserById")),
    })
    @Select("SELECT * FROM achievements OFFSET #{offset} LIMIT #{limit};")
    List<Achievement> getAllAchievements(@Param("offset") Integer offset, @Param("limit") Integer size);

    @ResultMap("achievementMapper")
    @Select("""
                SELECT a.*
                FROM achievements a
                INNER JOIN app_user_achievements aa ON a.achievement_id = aa.achievement_id
                WHERE aa.app_user_id = #{appUserId}
                OFFSET #{offset} LIMIT #{limit}
                ;
            """)
    List<Achievement> getAchievementsByAppUserId(@Param("appUserId") UUID appUserId, @Param("offset") Integer offset,
            @Param("limit") Integer size);

    @ResultMap("achievementMapper")
    @Select("""
               SELECT * FROM achievements WHERE xp_required <= #{xp_required};
            """)
    List<Achievement> getAchievementUnderXpRequired(@Param("xp_required") Long xpRequired);

    @Insert("""
                INSERT INTO app_user_achievements (app_user_id, achievement_id)
                VALUES (#{user_id}, #{achievement_id}) ON CONFLICT DO NOTHING;
            """)
    Boolean insertUserAchievement(@Param("user_id") UUID userId, @Param("achievement_id") UUID achievementId);
}