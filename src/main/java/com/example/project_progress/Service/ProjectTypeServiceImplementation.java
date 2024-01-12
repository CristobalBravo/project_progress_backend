package com.example.project_progress.Service;

import com.example.project_progress.Model.ProjectType;
import com.example.project_progress.Repository.ProjectTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeServiceImplementation implements ProjectTypeService{

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @Override
    public List<ProjectType> getAll(){
        return projectTypeRepository.findAll();
    }

    @Override
    public ProjectType save(ProjectType projectType) {
        return projectTypeRepository.save(projectType);
    }

    @Override
    public ProjectType findById(Long id) {
        Optional<ProjectType> optionalProjectType = projectTypeRepository.findById(id);
        return optionalProjectType.orElse(null);
    }

    @Override
    public void delete(ProjectType projectType) {
        projectTypeRepository.delete(projectType);
    }




}
