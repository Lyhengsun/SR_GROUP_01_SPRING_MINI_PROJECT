package com.example.gamified_habit_tracker.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.gamified_habit_tracker.model.dto.request.AppUserRequest;
import com.example.gamified_habit_tracker.model.entity.AppUser;

@Mapper
public interface AppUserRepository {
    @Results(id = "appUserMapper", value = {
            @Result(property = "appUserId", column = "app_user_id"),
            @Result(property = "profileImageUrl", column = "profile_image"),
            @Result(property = "iseVerified", column = "is_verified"),
            @Result(property = "createdAt", column = "created_at")
    })
    @Select("""
            SELECT * FROM app_users WHERE email = #{email};
            """)
    public AppUser getUserByEmail(String email);

    @ResultMap("appUserMapper")
    @Select("""
            SELECT * FROM app_users WHERE username = #{username};
            """)
    public AppUser getUserByUsername(String username);

    @ResultMap("appUserMapper")
    @Select("""
            SELECT * FROM app_users WHERE app_user_id = #{userId};
            """)
    public AppUser getUserByUserId(Long userId);

    @ResultMap("appUserMapper")
    @Select("""
            INSERT INTO app_users(username, email, password, profile_image)
            VALUES (#{req.appUsernmae}, #{req.email}, #{req.password}, #{req.profileImageUrl});
            """)
    public AppUser registerUser(@Param("req") AppUserRequest request);
}
