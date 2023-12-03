package com.example.securesaving.controller;

import com.example.securesaving.entity.UserAuthRequestBody;
import com.example.securesaving.entity.UserAuthResponse;
import com.example.securesaving.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAPIController {

    @Autowired
    UserAuthService userAuthService;

    @ResponseBody
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAuthResponse> login(@RequestBody UserAuthRequestBody userAuth) {
        return new ResponseEntity<>(userAuthService.login(userAuth), HttpStatus.OK);
    }
}