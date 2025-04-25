package com.portfolio.library_management.model;

import lombok.Data;

import java.util.UUID;
@Data
public class Auth {
    private String email;
    private String phoneNumber;
    private String name;
    private UUID id;
    private String token;
}
