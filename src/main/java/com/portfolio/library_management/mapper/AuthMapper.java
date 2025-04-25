package com.portfolio.library_management.mapper;

import com.portfolio.library_management.dto.AuthDTO.AuthReqDTO;
import com.portfolio.library_management.dto.AuthDTO.AuthResDTO;
import com.portfolio.library_management.model.Member.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    Member toEntity(AuthReqDTO dto);
    AuthResDTO toDto(Member auth);
}
