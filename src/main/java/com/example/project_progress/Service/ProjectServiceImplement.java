package com.example.project_progress.Service;

import com.example.project_progress.Constant.ProjectStateConstant;
import com.example.project_progress.Model.Project;
import com.example.project_progress.Model.ProjectProgress;
import com.example.project_progress.Model.ProjectState;
import com.example.project_progress.Model.ProjectType;
import com.example.project_progress.Repository.ProjectProgressRepository;
import com.example.project_progress.Repository.ProjectRepository;
import com.example.project_progress.Response.ProjectProgressResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    private ProjectProgressRepository projectProgressRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    @Transactional
    public Project save(Project project) {

        if(project.getId() != null && project.getId() > 0){
            Project searchProject = findById(project.getId());
            if(!Objects.equals(searchProject.getProjectState().getId(), project.getProjectState().getId())){
                saveProjectProgress(project.getId(), project.getProjectState().getId());
            }

            ProjectState projectState = projectStateService.findById(project.getProjectState().getId());
            ProjectType projectType = projectTypeService.findById(project.getProjectType().getId());

            project.setProjectState(projectState);
            project.setProjectType(projectType);
            return projectRepository.save(project);
        }else{
            ProjectState projectStateCreate = projectStateService.findById((long) ProjectStateConstant.INITED);
            project.setProjectState(projectStateCreate);
            Project projectSave =  projectRepository.save(project);
            saveProjectProgress(projectSave.getId(), projectStateCreate.getId());
            return projectSave;

        }

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

    @Transactional
    private void saveProjectProgress(Long p_id, Long ps_id){
        ProjectProgress projectProgress = new ProjectProgress();
        projectProgress.setPs_id(ps_id);
        projectProgress.setP_id(p_id);
        projectProgressRepository.save(projectProgress);
    }


    @Override
    public List<ProjectProgressResponse> getAllByProjectID(Long p_id) {
        List<ProjectProgress> projectProgressesFetch = projectProgressRepository.findByProjectID(p_id);
        List<ProjectProgressResponse > projectProgressResponsesList = new ArrayList<>();
        for (ProjectProgress progress : projectProgressesFetch) {
            ProjectProgressResponse progressResponse = new ProjectProgressResponse();

            Long project_id = progress.getP_id();
            Long project_state_id = progress.getPs_id();
            LocalDateTime pg_date = progress.getPg_date();
            Long project_progress_id = progress.getP_id();

            ProjectState projectState = projectStateService.findById(project_state_id);
            Project project = findById(project_id);

            progressResponse.setProject(project);
            progressResponse.setProjectState(projectState);
            progressResponse.setPg_date(pg_date);
            progressResponse.setId(project_progress_id);

            projectProgressResponsesList.add(progressResponse);

        }
        return projectProgressResponsesList;
    }
}
