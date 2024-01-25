package com.example.project_progress.Service;

import com.example.project_progress.Model.Project;
import com.example.project_progress.Model.ProjectState;

import java.util.List;

public interface ProjectService {

    List<Project> getAll();
    Project save(Project project);
    Project findById(Long id);
    void delete(Project project);
}
