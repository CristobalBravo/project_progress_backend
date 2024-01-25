package com.example.project_progress.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "profession")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pr_name;

    public Profession() {
    }

    public Profession(Long id, String pr_name) {
        this.id = id;
        this.pr_name = pr_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPr_name() {
        return pr_name;
    }

    public void setPr_name(String pr_name) {
        this.pr_name = pr_name;
    }
}
