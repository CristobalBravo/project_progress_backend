package com.example.project_progress.Response;

import com.example.project_progress.Model.Project;
import com.example.project_progress.Model.ProjectState;

import java.time.LocalDateTime;

public class ProjectProgressResponse {

    private Long id;
    private LocalDateTime pg_date;
    private ProjectState projectState;
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectState getProjectState() {
        return projectState;
    }

    public void setProjectState(ProjectState projectState) {
        this.projectState = projectState;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDateTime getPg_date() {
        return pg_date;
    }

    public void setPg_date(LocalDateTime pg_date) {
        this.pg_date = pg_date;
    }
}
