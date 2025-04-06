package com.example.gamified_habit_tracker.model.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser implements UserDetails {
    private UUID appUserId;
    private String appUsername;
    private String email;
    private String password;
    private Long level;
    private Long xp;
    private String profileImageUrl;
    private Boolean isVerified;
    private LocalDateTime createdAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
