package com.example.project_progress.Service;

import com.example.project_progress.Model.ProjectType;

import java.util.List;

public interface ProjectTypeService {

    List<ProjectType> getAll();
    ProjectType save(ProjectType projectType);
    ProjectType findById(Long id);
    void delete(ProjectType projectType);
}
