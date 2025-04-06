package com.example.gamified_habit_tracker.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.util.UUID;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class AppUserResponse {
    private UUID appUserId;
    private String appUserName;
    private String appUserEmail;
    private Long level;
    private Long xp = 10l;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createAt;
}
