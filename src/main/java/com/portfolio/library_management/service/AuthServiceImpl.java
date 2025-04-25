package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.AuthDTO.AuthReqDTO;
import com.portfolio.library_management.dto.AuthDTO.AuthResDTO;
import com.portfolio.library_management.mapper.AuthMapper;
import com.portfolio.library_management.model.Member.Member;
import com.portfolio.library_management.repository.MemberRepository;

import com.portfolio.library_management.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MemberRepository repository;
    private final AuthMapper mapper;
    private final JwtService jwtService;

    @Override
    public AuthResDTO login(AuthReqDTO dto) {

        Member member = (Member) repository.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        AuthResDTO res = mapper.toDto(member); // ✅ convert Member to AuthResDTO
        String token = jwtService.generateToken(res);
        res.setToken(token);

        return res;
    }
}
