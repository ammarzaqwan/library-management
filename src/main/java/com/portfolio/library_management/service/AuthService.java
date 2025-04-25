package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.AuthDTO.AuthReqDTO;
import com.portfolio.library_management.dto.AuthDTO.AuthResDTO;

public interface AuthService {

    AuthResDTO login(AuthReqDTO dto);
}
