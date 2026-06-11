package com.rohan.lovable_clone.service.impl;

import com.rohan.lovable_clone.dto.member.InviteMemberRequest;
import com.rohan.lovable_clone.dto.member.MemberResponse;
import com.rohan.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.rohan.lovable_clone.service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getProjectMembers(Long userId, Long projectId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
