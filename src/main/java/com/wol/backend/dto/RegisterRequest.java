package com.wol.backend.dto;

import com.wol.backend.entity.UserRole;

public record RegisterRequest(
        String name,
        String email,
        String password,
        UserRole role // HOST или PEER
) {}