package com.example.project_progress.Service;

import com.example.project_progress.Model.Project;
import com.example.project_progress.Model.ProjectProgress;
import com.example.project_progress.Model.ProjectState;
import com.example.project_progress.Response.ProjectProgressResponse;

import java.util.List;

public interface ProjectService {

    List<Project> getAll();
    Project save(Project project);
    Project findById(Long id);
    void delete(Project project);

    List<ProjectProgressResponse> getAllByProjectID(Long p_id);
}
