package com.example.securesaving.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Accounts {
    @Id
    private String id;
    private String userId;
    private long accountNumber;
    private double availableBalance;
    private String accountType;
    private String accountStatus;
    private String IFSCCode;
}
