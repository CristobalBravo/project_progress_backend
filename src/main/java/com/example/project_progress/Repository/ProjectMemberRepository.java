package com.example.project_progress.Repository;

import com.example.project_progress.Model.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long> {

    @Query(value = "SELECT pm FROM ProjectMember pm WHERE pm.p_id =:p_id")
    List<ProjectMember> findByProjectID(Long p_id);
}
