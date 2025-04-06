package com.example.gamified_habit_tracker.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {
    private UUID appUserId;
    private String appUserName;
    private String appUserEmail;
    private UUID password;
    private Long level;
    private Long xp = 10l;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createAt;
}
