package com.rohan.lovable_clone.dto.member;

import com.rohan.lovable_clone.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
