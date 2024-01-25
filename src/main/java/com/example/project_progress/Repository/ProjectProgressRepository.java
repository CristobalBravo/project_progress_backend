package com.example.project_progress.Repository;

import com.example.project_progress.Model.ProjectProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectProgressRepository extends JpaRepository<ProjectProgress,Long> {

    @Query(value = "SELECT pp FROM ProjectProgress pp WHERE pp.p_id =:p_id")
    List<ProjectProgress> findByProjectID(Long p_id);
}
