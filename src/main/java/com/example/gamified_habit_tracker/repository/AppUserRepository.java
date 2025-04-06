package com.example.gamified_habit_tracker.repository;

import java.util.UUID;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.example.gamified_habit_tracker.config.UUIDTypeHandler;
import com.example.gamified_habit_tracker.model.dto.request.AppUserRequest;
import com.example.gamified_habit_tracker.model.dto.request.ProfileRequest;
import com.example.gamified_habit_tracker.model.entity.AppUser;

@Mapper
public interface AppUserRepository {
    @Results(id = "appUserMapper", value = {
            @Result(property = "appUserId", column = "app_user_id", jdbcType = JdbcType.VARCHAR, javaType = UUID.class, typeHandler = UUIDTypeHandler.class),
            @Result(property = "appUsername", column = "username"),
            @Result(property = "profileImageUrl", column = "profile_image"),
            @Result(property = "isVerified", column = "is_verified"),
            @Result(property = "createdAt", column = "created_at")
    })
    @Select("""
            SELECT * FROM app_users WHERE email = #{email};
            """)
    public AppUser getUserByEmail(@Param("email") String email);

    @ResultMap("appUserMapper")
    @Select("""
            SELECT * FROM app_users WHERE username = #{username};
            """)
    public AppUser getUserByUsername(@Param("username") String username);

    @ResultMap("appUserMapper")
    @Select("""
            SELECT * FROM app_users WHERE app_user_id = #{user_id};
            """)
    public AppUser getUserByUserId(@Param("user_id") UUID userId);

    @ResultMap("appUserMapper")
    @Select("""
            INSERT INTO app_users(username, email, password, profile_image)
            VALUES (#{req.username}, #{req.email}, #{req.password}, #{req.profileImageUrl})
            RETURNING *;
            """)
    public AppUser registerUser(@Param("req") AppUserRequest request);

    @ResultMap("appUserMapper")
    @Select("""
                UPDATE app_users SET
                username=#{req.username},
                profile_image=#{req.profileImageUrl}
                WHERE app_user_id = #{user_id}
                RETURNING *;
            """)
    public AppUser updateUserProfile(@Param("user_id") UUID appUserId, @Param("req") ProfileRequest request);

    @ResultMap("appUserMapper")
    @Select("""
                DELETE FROM app_users
                WHERE app_user_id = #{user_id}
                RETURNING *;
            """)
    public AppUser deleteUserProfileById(@Param("user_id") UUID appUserId);
}
