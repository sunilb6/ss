package com.example.securesaving.service;

import com.example.securesaving.entity.auth.AuthResponse;

import java.util.Map;

public interface AuthService {
    Map<String, String> getAccessToken(String token);
}
