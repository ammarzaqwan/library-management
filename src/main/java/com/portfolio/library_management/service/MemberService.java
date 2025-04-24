package com.portfolio.library_management.service;

import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;
import com.portfolio.library_management.dto.MemberDto.MemberResDTO;

import java.util.List;
import java.util.UUID;

public interface MemberService {

   List<MemberResDTO> getAllMembers() ;
    MemberResDTO addMember(MemberReqDTO dto);
    MemberResDTO getMembers(UUID uuid);
    void deleteMember(UUID uuid);
    MemberResDTO updMember(UUID id, MemberReqDTO dto);
 }
