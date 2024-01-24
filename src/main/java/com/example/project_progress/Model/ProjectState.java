package com.example.project_progress.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "project_state")
public class ProjectState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ps_color;
    private String ps_name;

    public ProjectState() {
    }

    public ProjectState(Long id, String ps_color, String ps_name) {
        this.id = id;
        this.ps_color = ps_color;
        this.ps_name = ps_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPs_color() {
        return ps_color;
    }

    public void setPs_color(String ps_color) {
        this.ps_color = ps_color;
    }

    public String getPs_name() {
        return ps_name;
    }

    public void setPs_name(String ps_name) {
        this.ps_name = ps_name;
    }
}
