package com.portfolio.library_management.dto.MemberDto;

import com.portfolio.library_management.model.MemberStatus;
import com.portfolio.library_management.model.Role;
import lombok.Data;

import java.util.UUID;

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
