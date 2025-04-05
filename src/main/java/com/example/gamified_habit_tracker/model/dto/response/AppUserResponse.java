package com.example.gamified_habit_tracker.model.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserResponse {
    private Long appUserId;
    private String username;
    private String email;
    private Long level;
    private Long xp;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createdAt;
}
