package com.rohan.lovable_clone.mapper;

import com.rohan.lovable_clone.dto.project.ProjectResponse;
import com.rohan.lovable_clone.dto.project.ProjectSummaryResponse;
import com.rohan.lovable_clone.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
