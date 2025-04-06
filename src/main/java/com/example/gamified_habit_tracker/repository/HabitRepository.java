package com.example.gamified_habit_tracker.repository;

import com.example.gamified_habit_tracker.config.UUIDTypeHandler;
import com.example.gamified_habit_tracker.model.entity.AppUser;
import com.example.gamified_habit_tracker.model.entity.Habits;
import com.example.gamified_habit_tracker.model.request.AppUserRequest;
import com.example.gamified_habit_tracker.model.request.HabitRequest;
import com.example.gamified_habit_tracker.model.response.AppUserResponse;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Mapper
public interface HabitRepository {

    @Select("""
        SELECT * FROM habits hs INNER JOIN app_users au ON hs.habit_id = au.app_user_id
        OFFSET #{offset} LIMIT #{size}
        """)
    @Results(id = "habitMapper",value = {
            @Result(property = "habitId",column = "habit_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
            @Result(property = "title",column = "title"),
            @Result(property = "description",column = "description"),
            @Result(property = "frequency",column = "frequency"),
            @Result(property = "isActive",column = "is_active"),
            @Result(property = "appUserResponse",column = "app_user_id", one = @One(select = "getUserById")),
            @Result(property = "createAt",column = "create_at")
    })
    List<Habits> getAllHabit(int offset,int size);

    @Select("""
        SELECT * from app_users where app_user_id = #{uuid}
        """)
    @Results(id = "useMapper",value = {
            @Result(property = "appUserId",column = "app_user_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
            @Result(property = "appUserName",column = "user_name"),
            @Result(property = "appUserEmail",column = "email"),
            @Result(property = "level",column = "level"),
            @Result(property = "xp",column = "xp"),
            @Result(property = "profileImageUrl",column = "profile_image"),
            @Result(property = "isVerified",column = "is_verified"),
            @Result(property = "createAt",column = "create_at")
    })
    AppUserResponse getUserById(UUID uuid);

    @Select("""
        SELECT * FROM habits hs INNER JOIN app_users au ON hs.habit_id = au.app_user_id where habit_id = #{uuid}
        """)
    @ResultMap("habitMapper")
    Habits getHabitById(UUID uuid);


    @Select("""
        UPDATE habits SET title = #{req.title},description =  #{req.description},frequency = #{req.frequency},is_active = #{req.isActive}, app_user_id = #{req.appUser} WHERE habit_id = #{uuid};
        """)
    @ResultMap("habitMapper")
    Habits updateHabitById(UUID uuid,@Param("req") HabitRequest habitRequest);

    @Select("""
        UPDATE update app_users set user_name =#{req.appUserName} ,email =#{req.appUserEmail} , password =#{req.password} ,level = #{req.level},profile_image =#{req.profileImageUrl} ,is_verified =#{req.createAt} , where app_user_id = #{uuid}
        """)
    @ResultMap("useMapper")
    AppUser update(@Param("req") AppUserRequest appUserRequest, UUID uuid);

    @Select("""
        delete from habits where app_user_id = #{uuid};
        """)
    @ResultMap("habitMapper")
    Habits deleteHabitById(UUID uuid);

    @Select("""
        INSERT INTO habits (title,description,frequency,is_active,app_user_id,create_at) VALUES (#{req.title},#{req.description},#{req.frequency},#{req.profileImage},#{req.isActive},#{req.appUserId},NOW())
        """)
    @ResultMap("habitMapper")
    Habits createHabit(@Param("req") HabitRequest request);

    @Select("""
        INSERT INTO app_users(user_name, email, password, level, profile_image, is_verified, create_at) values (#{req.userName},#{req.email},#{req.password},#{req.level},#{req.profileImage},#{req.isVeried},NOW()) 
        """)
    @ResultMap("useMapper")
    AppUser createAppUser(@Param("req") AppUserRequest appUserRequest,UUID uuid);
}
