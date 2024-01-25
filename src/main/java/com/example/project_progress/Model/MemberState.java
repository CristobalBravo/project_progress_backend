package com.example.project_progress.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "member_state")
public class MemberState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ms_name;

    public MemberState() {
    }

    public MemberState(Long id, String ms_name) {
        this.id = id;
        this.ms_name = ms_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMs_name() {
        return ms_name;
    }

    public void setMs_name(String ms_name) {
        this.ms_name = ms_name;
    }
}
