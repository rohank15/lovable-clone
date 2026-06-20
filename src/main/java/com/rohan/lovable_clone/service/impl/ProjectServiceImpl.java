package com.rohan.lovable_clone.service.impl;

import com.rohan.lovable_clone.entity.Project;
import com.rohan.lovable_clone.entity.ProjectMember;
import com.rohan.lovable_clone.entity.ProjectMemberId;
import com.rohan.lovable_clone.entity.User;
import com.rohan.lovable_clone.enums.ProjectRole;
import com.rohan.lovable_clone.error.ResourceNotFoundException;
import com.rohan.lovable_clone.mapper.ProjectMapper;
import com.rohan.lovable_clone.repository.ProjectMemberRepository;
import com.rohan.lovable_clone.repository.ProjectRepository;
import com.rohan.lovable_clone.dto.project.ProjectRequest;
import com.rohan.lovable_clone.dto.project.ProjectResponse;
import com.rohan.lovable_clone.dto.project.ProjectSummaryResponse;
import com.rohan.lovable_clone.repository.UserRepository;
import com.rohan.lovable_clone.security.AuthUtil;
import com.rohan.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;
    private final ProjectMemberRepository projectMemberRepository;

    private final AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        User owner = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", userId.toString())
        );

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new  ProjectMemberId(project.getId(), userId);
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(owner)
                .projectRole(ProjectRole.OWNER)
                .invitedAt(Instant.now())
                .acceptedAt(Instant.now())
                .build();
        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();

        List<Project> projects = projectRepository.findAllAccessibleByUser(userId);

        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);

        project.setDeletedAt(Instant.now());

        projectRepository.save(project);
    }

    /// INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long id, Long userId) {
        return  projectRepository.findAccessibleProjectById(id, userId).orElseThrow(() -> new ResourceNotFoundException("Project", id.toString()));
    }
}
