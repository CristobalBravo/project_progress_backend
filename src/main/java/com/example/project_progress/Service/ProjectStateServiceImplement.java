package com.example.project_progress.Service;

import com.example.project_progress.Model.ProjectState;
import com.example.project_progress.Model.ProjectType;
import com.example.project_progress.Repository.ProjectStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectStateServiceImplement implements ProjectStateService{

    @Autowired
    private ProjectStateRepository projectStateRepository;


    @Override
    public List<ProjectState> getAll() {
        return projectStateRepository.findAll();
    }

    @Override
    public ProjectState save(ProjectState projectState) {
        return projectStateRepository.save(projectState);
    }

    @Override
    public ProjectState findById(Long id) {
        Optional<ProjectState> optionalProjectState = projectStateRepository.findById(id);
        return optionalProjectState.orElse(null);
    }

    @Override
    public void delete(ProjectState projectState) {
        projectStateRepository.delete(projectState);
    }
}
