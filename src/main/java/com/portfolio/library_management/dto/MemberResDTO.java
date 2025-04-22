package com.portfolio.library_management.dto;

import com.portfolio.library_management.model.MemberStatus;
import com.portfolio.library_management.model.Role;

import java.util.UUID;

import lombok.Data;

@Data
public class MemberResDTO {
    private UUID id;
    private String email;
    private String name;
    private String phoneNumber;
    private boolean emailVerified;
    private Role role;
    private MemberStatus status;
    private int borrowLimit;
    private double lateFees;
}
