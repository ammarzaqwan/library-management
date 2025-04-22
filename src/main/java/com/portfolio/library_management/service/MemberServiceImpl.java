package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.MemberReqDTO;
import com.portfolio.library_management.dto.MemberResDTO;
import com.portfolio.library_management.mapper.MemberMapper;
import com.portfolio.library_management.model.Member;
import com.portfolio.library_management.model.MemberStatus;
import com.portfolio.library_management.model.Role;
import com.portfolio.library_management.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public  class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;
    private final MemberMapper mapper;

    @Override
    public MemberResDTO addMember(MemberReqDTO dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists: " + dto.getEmail());
        }
        Member member = mapper.toEntity(dto);

        if (member.getRole() == null) member.setRole(Role.ROLE_USER);
        if (member.getStatus() == null) member.setStatus(MemberStatus.ACTIVE);
        if (member.getBorrowLimit() == 0) member.setBorrowLimit(5);
        if (member.getLateFees() == 0.0) member.setLateFees(0.0);
        if (!member.isEmailVerified()) member.setEmailVerified(false);
        member.setAuthProvider("LOCAL");

        Member saved = repository.save(member);
        return mapper.toDto(saved);
    }


}

