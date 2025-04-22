package com.portfolio.library_management.mapper;


import com.portfolio.library_management.dto.MemberReqDTO;
import com.portfolio.library_management.dto.MemberResDTO;
import com.portfolio.library_management.model.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toEntity(MemberReqDTO dto);
    MemberResDTO toDto(Member member);
}



