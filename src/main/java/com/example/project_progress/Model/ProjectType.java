package com.example.project_progress.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "project_type")
public class ProjectType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pt_name;

    public ProjectType() {
    }

    public ProjectType(Long id, String pt_name) {
        this.id = id;
        this.pt_name = pt_name;
    }

    public Long getId() {
        return id;
    }

    public String getPt_name() {
        return pt_name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPt_name(String pt_name) {
        this.pt_name = pt_name;
    }
}
