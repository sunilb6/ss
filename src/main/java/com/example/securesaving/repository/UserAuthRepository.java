package com.example.securesaving.repository;

import com.example.securesaving.entity.UserAuthResponse;
import com.example.securesaving.entity.user.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserAuthRepository extends MongoRepository<Users, String> {
    @Query("{ 'userId' : ?0 }, { 'password' : ?1 }")
    UserAuthResponse findUserByUserIdPassword(String userId, String password);

    @Query("{ 'userId' : ?0 }")
    UserAuthResponse findUserByUserId(String userId);
}
