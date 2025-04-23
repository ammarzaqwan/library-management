package com.portfolio.library_management.controller;

import com.portfolio.library_management.dto.MemberDto.MemberReqDTO;
import com.portfolio.library_management.dto.MemberDto.MemberResDTO;
import com.portfolio.library_management.model.Member;
import com.portfolio.library_management.service.MemberService;
import com.portfolio.library_management.utils.ApiResponse;
import com.portfolio.library_management.utils.Record;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;


    @PostMapping("/api/public/members")
    public ResponseEntity<ApiResponse<MemberResDTO>> addMember(@Valid @RequestBody MemberReqDTO dto) {
        MemberResDTO member = service.addMember(dto);

        ApiResponse<MemberResDTO> response = new ApiResponse<>(
                "Member created successfully",
                member,
                HttpStatus.CREATED.value()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping ("/api/public/members")
    public ResponseEntity<ApiResponse<List<MemberResDTO>>> getAllMembers() {
        List<MemberResDTO> member = service.getAllMembers();
        ApiResponse<List<MemberResDTO>> response = new ApiResponse<>(
                Record.RETRIEVE.getMessage(),
                member,
                HttpStatus.OK.value()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping ("/api/public/members/{uuid}")
    public ResponseEntity<MemberResDTO>  getMembers(@PathVariable UUID uuid){
        return new ResponseEntity<>(service.getMembers(uuid), HttpStatus.OK);
    }
    @DeleteMapping ("/api/public/members/{uuid}")
    public ResponseEntity<Void> deleteMember(@PathVariable UUID uuid) {
        // Call the service layer to delete the member
        service.deleteMember(uuid);

        // Return HTTP 204 No Content on successful deletion
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, world!");
    }

}
