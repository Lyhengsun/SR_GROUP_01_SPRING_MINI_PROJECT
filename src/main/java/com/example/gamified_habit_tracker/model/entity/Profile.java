package com.example.gamified_habit_tracker.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    private long appUserId;
    private String userName;
    private String email;
    private String password;
    private String level;
    private String xp;
    private String profileImage;
    private String isVerified;
    private String createdAt;
}
