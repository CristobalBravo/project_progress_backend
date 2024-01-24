package com.example.project_progress.Service;

import com.example.project_progress.Model.ProjectState;
import com.example.project_progress.Model.ProjectType;

import java.util.List;

public interface ProjectStateService {

    List<ProjectState> getAll();
    ProjectState save(ProjectState projectState);
    ProjectState findById(Long id);
    void delete(ProjectState projectState);
}
