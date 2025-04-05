package com.example.gamified_habit_tracker.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppUser {
    private UUID appUserId;
    private String appUserName;
    private String appUserEmail;
    private Long level;
    private Long xp = 10l;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createAt;
}
