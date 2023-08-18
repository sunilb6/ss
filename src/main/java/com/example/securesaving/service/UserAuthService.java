package com.example.securesaving.service;

import com.example.securesaving.entity.UserAuthResponse;
import com.example.securesaving.entity.UserAuthRequestBody;

public interface UserAuthService {
    UserAuthResponse login(UserAuthRequestBody userAuthRequestBody);
}
