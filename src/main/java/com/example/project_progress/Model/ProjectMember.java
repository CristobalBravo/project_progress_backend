package com.example.project_progress.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_member")
public class ProjectMember {

    private Long id;
    private Long p_id;
    private Long m_id;

    public ProjectMember() {
    }

    public ProjectMember(Long id, Long p_id, Long m_id) {
        this.id = id;
        this.p_id = p_id;
        this.m_id = m_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public Long getM_id() {
        return m_id;
    }

    public void setM_id(Long m_id) {
        this.m_id = m_id;
    }
}
