package com.portfolio.library_management.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "members", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phoneNumber")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseModel {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    private String name;

    private String phoneNumber;

    private String password; // null for OAuth users

    @Column(nullable = false)
    private String authProvider; // "LOCAL", "GOOGLE", etc.

    private String providerId; // OAuth provider user ID

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberStatus status;

    private boolean isEmailVerified;  // To track email verification status

    @Column(nullable = false)
    private int borrowLimit;  // Max books user can borrow at once

    @Column(nullable = false)
    private double lateFees;  // Fees for overdue books (in dollars or other currency)

    @PrePersist
    public void prePersist() {
        if (this.role == null) {
            this.role = Role.ROLE_USER;
        }
        if (this.status == null) {
            this.status = MemberStatus.ACTIVE;
        }
        if (this.isEmailVerified == false) {
            this.isEmailVerified = false;  // Set false until verified
        }
        if (this.borrowLimit == 0) {
            this.borrowLimit = 5;  // Default borrow limit
        }
        if (this.lateFees == 0) {
            this.lateFees = 0.0;  // Default late fee (no fees by default)
        }
    }
}
