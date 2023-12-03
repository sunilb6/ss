package com.example.securesaving.controller;

import com.example.securesaving.entity.auth.AuthResponse;
import com.example.securesaving.service.AuthService;
import com.example.securesaving.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @ResponseBody
    @GetMapping("/getAccessToken")
    public ResponseEntity<Map<String, String>> getAccessToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        String token = authHeader.split(" ")[1];

        if (token.isEmpty() || token.isBlank()) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } else {
            Map<String, String> result = authService.getAccessToken(token);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

}