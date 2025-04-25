package com.portfolio.library_management.controller;

import com.portfolio.library_management.dto.AuthDTO.AuthReqDTO;
import com.portfolio.library_management.dto.AuthDTO.AuthResDTO;
import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;
import com.portfolio.library_management.dto.MemberDto.MemberResDTO;
import com.portfolio.library_management.service.AuthService;
import com.portfolio.library_management.utils.ApiResponse;
import com.portfolio.library_management.utils.Record;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResDTO>> login(@RequestBody AuthReqDTO dto) {

        AuthResDTO authRes = authService.login(dto);
        ApiResponse<AuthResDTO> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                authRes,
                HttpStatus.OK.value()
        );
        return new
                ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
