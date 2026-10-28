package com.wol.backend.controller;

import com.wol.backend.dto.AuthResponse;
import com.wol.backend.dto.LoginRequest;
import com.wol.backend.dto.RegisterRequest;
import com.wol.backend.service.AuthService; // <-- Проверь эту строку!
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}