package com.portfolio.library_management.mapper;



import com.portfolio.library_management.dto.BookDTO.BookReqDTO;
import com.portfolio.library_management.dto.BookDTO.BookResDTO;
import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;
import com.portfolio.library_management.dto.MemberDto.MemberResDTO;
import com.portfolio.library_management.model.Book.Book;
import com.portfolio.library_management.model.Member.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookReqDTO dto);
    BookResDTO toDto(Book book);
}



