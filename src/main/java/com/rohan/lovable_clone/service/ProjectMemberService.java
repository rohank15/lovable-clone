package com.rohan.lovable_clone.service;

import com.rohan.lovable_clone.dto.member.InviteMemberRequest;
import com.rohan.lovable_clone.dto.member.MemberResponse;
import com.rohan.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.rohan.lovable_clone.entity.ProjectMember;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
