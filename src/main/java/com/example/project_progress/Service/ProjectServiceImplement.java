package com.example.project_progress.Service;

import com.example.project_progress.Constant.ProjectStateConstant;
import com.example.project_progress.Model.Project;
import com.example.project_progress.Model.ProjectState;
import com.example.project_progress.Model.ProjectType;
import com.example.project_progress.Repository.ProjectRepository;
import com.example.project_progress.Repository.ProjectStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectServiceImplement implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectStateService projectStateService;

    @Autowired
    private ProjectTypeService projectTypeService;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {

        if(project.getId() != null || project.getId() > 0){
            Project searchProject = findById(project.getId());
            if(!Objects.equals(searchProject.getProjectState().getId(), project.getProjectState().getId())){
                //guardamos el historial de cambio;

            }

            ProjectState projectState = projectStateService.findById(project.getProjectState().getId());
            ProjectType projectType = projectTypeService.findById(project.getProjectType().getId());

            project.setProjectState(projectState);
            project.setProjectType(projectType);
        }else{
            ProjectState projectStateCreate = projectStateService.findById((long) ProjectStateConstant.INITED);
            project.setProjectState(projectStateCreate);
        }
        return projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        return optionalProject.orElse(null);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }
}
