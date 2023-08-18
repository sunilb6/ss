package com.example.securesaving.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document
public class Users {
    @Id
    private String id;
    private long userId;
    private String password;
    private String firstName;
    private String lastName;
    private Identity identity;
    private Contact contact;
}