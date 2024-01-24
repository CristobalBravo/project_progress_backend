package com.example.project_progress.Repository;

import com.example.project_progress.Model.ProjectState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectStateRepository extends JpaRepository<ProjectState, Long> {
}
