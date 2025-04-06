package com.example.gamified_habit_tracker.model.dto.response;


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
public class AppUserResponse {
    private String username;
    private String email;
    private Long level;
    private Long xp;
    private String profileImageUrl;
    private boolean isVerified;
    private LocalDateTime createdAt;
}
