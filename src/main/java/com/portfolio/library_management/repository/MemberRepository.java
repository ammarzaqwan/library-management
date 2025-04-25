package com.portfolio.library_management.repository;

import com.portfolio.library_management.model.Member.Member;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Object> findByEmail(@NotBlank(message = "Email is required") String email);
    Optional<Object> findByEmailAndPassword(@NotBlank(message = "Email is required") String email, @NotBlank(message = "Password is required") String password);
}