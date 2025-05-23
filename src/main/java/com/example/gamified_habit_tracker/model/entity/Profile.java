package com.example.gamified_habit_tracker.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {
    private UUID appUserId;
    private String userName;
    private String email;
    private String password;
    private Long level;
    private Long xp;
    private String profileImage;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private List<Achievement> achievements;
}
