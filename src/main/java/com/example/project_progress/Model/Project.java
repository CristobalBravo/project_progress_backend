package com.example.project_progress.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String p_name;
    private String p_description;
    @ManyToOne
    @JoinColumn(name = "project_state_id")
    private ProjectState projectState;

    @ManyToOne
    @JoinColumn(name = "project_type_id")
    private ProjectType projectType;


    public Project() {
    }

    public Project(Long id, String p_name, String p_description, ProjectState projectState, ProjectType projectType) {
        this.id = id;
        this.p_name = p_name;
        this.p_description = p_description;
        this.projectState = projectState;
        this.projectType = projectType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    public ProjectState getProjectState() {
        return projectState;
    }

    public void setProjectState(ProjectState projectState) {
        this.projectState = projectState;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
}
