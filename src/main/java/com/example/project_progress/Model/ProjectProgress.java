package com.example.project_progress.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "project_progress")
public class ProjectProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long p_id;

    private Long ps_id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime pg_date;

    public ProjectProgress() {
    }

    public ProjectProgress(Long p_id, Long ps_id, Long id) {
        this.p_id = p_id;
        this.ps_id = ps_id;
        this.id = id;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public Long getPs_id() {
        return ps_id;
    }

    public void setPs_id(Long ps_id) {
        this.ps_id = ps_id;
    }

    public LocalDateTime getPg_date() {
        return pg_date;
    }

    public void setPg_date(LocalDateTime pg_date) {
        this.pg_date = pg_date;
    }

    @PrePersist
    public void prePersist() {
        if (pg_date == null) {
            pg_date = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
