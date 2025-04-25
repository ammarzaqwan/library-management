package com.portfolio.library_management.dto.AuthDTO;

import lombok.Data;

import java.util.UUID;
@Data
public class AuthResDTO {
    private String email;
    private String phoneNumber;
    private String name;
    private UUID id;
    private String token;
}
