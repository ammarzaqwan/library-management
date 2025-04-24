package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;
import com.portfolio.library_management.dto.MemberDto.MemberResDTO;
import com.portfolio.library_management.exception.ApiException;
import com.portfolio.library_management.mapper.MemberMapper;
import com.portfolio.library_management.model.Member.Member;
import com.portfolio.library_management.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public  class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;
    private final MemberMapper mapper;

    @Override
    public MemberResDTO addMember(MemberReqDTO dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new ApiException("Email already exists", HttpStatus.BAD_REQUEST);
        }
        Member member = mapper.toEntity(dto);

        member.setAuthProvider("LOCAL");

        try {
            Member saved = repository.save(member);
            return mapper.toDto(saved);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Email or phone number already exists", HttpStatus.BAD_REQUEST);
        }

    }

    public List<MemberResDTO> getAllMembers() {
        List<Member> members = repository.findAll();
        if (members.isEmpty()) {
            throw new ApiException("No members found", HttpStatus.NOT_FOUND);
        }
        return members.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public MemberResDTO getMembers(UUID id) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new  ApiException("Member not exist", HttpStatus.BAD_REQUEST));

        return mapper.toDto(member);
    }

    public MemberResDTO updMember(UUID id, MemberReqDTO dto) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new ApiException("Member not exist", HttpStatus.BAD_REQUEST));

        member.setEmail(dto.getEmail());
        member.setName(dto.getName());
        member.setPhoneNumber(dto.getPhoneNumber());

        try {
            Member saved = repository.save(member);
            return mapper.toDto(saved);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Email or phone number already exists", HttpStatus.BAD_REQUEST);
        }
    }
    public void deleteMember(UUID id) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new ApiException("Member not found", HttpStatus.NOT_FOUND));
        repository.delete(member);
    }


}

