package com.rohan.lovable_clone.dto.member;

import com.rohan.lovable_clone.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
