package com.example.securesaving.service;

import com.example.securesaving.entity.UserAuthRequestBody;
import com.example.securesaving.entity.UserAuthResponse;
import com.example.securesaving.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService{

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserAuthResponse login(UserAuthRequestBody userAuthRequestBody) {
        UserAuthResponse userAuthResponse = userAuthRepository.findUserByUserIdPassword(userAuthRequestBody.getUserId(),
                userAuthRequestBody.getPassword());
        return new UserAuthResponse("ewrwer", "sgdfg");
    }
}
