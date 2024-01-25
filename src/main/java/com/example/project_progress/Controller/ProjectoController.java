package com.example.project_progress.Controller;

import com.example.project_progress.Model.Project;
import com.example.project_progress.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/project")
public class ProjectoController {

    @Autowired
    private ProjectService projectService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<Project> projects = projectService.getAll();
        String message = "Pproyectos obtenidos con éxito";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("projects", projects);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{p_id}")
    public ResponseEntity<?> getById(@PathVariable Long p_id) {

        Map<String, Object> response = new HashMap<>();

        if (p_id == null) {
            String message = "No fue enviado el código de el proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Project project = projectService.findById(p_id);

        if (project == null) {
            String message = "No se encontro el proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        String message = "Estado de proyecto obtenido con exito";
        response.put("message", message);
        response.put("project", project);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Project project) {

        Map<String, Object> response = new HashMap<>();

        if (project.getP_name() == null || project.getP_name().isEmpty()) {
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Project projectStateFetch = projectService.save(project);

        if (projectStateFetch == null) {
            String message = "No se pudo crear el proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        String message = "Proyecto creado con éxito";
        response.put("message", message);
        response.put("Project", projectStateFetch);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/{p_id}")
    public ResponseEntity<?> update(@PathVariable Long p_id, @RequestBody Project project) {

        Map<String, Object> response = new HashMap<>();

        if (project.getP_name() == null || project.getP_name().isEmpty()) {
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Project projectFetch = projectService.findById(p_id);

        if (projectFetch == null) {
            String message = "No se encontro el proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }


        Project projectSave = projectService.save(project);

        if (projectSave == null) {
            String message = "No se pudo actualizar el estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        String message = "Proyecto editado con éxito";
        response.put("message", message);
        response.put("Project", projectSave);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{p_id}")
    public ResponseEntity<?> delete(@PathVariable Long p_id) {

        Map<String, Object> response = new HashMap<>();

        if (p_id == null) {
            String message = "No fue enviado el código de el proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Project projectSave = projectService.findById(p_id);

        if (projectSave == null) {
            String message = "No se encontro el proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        projectService.delete(projectSave);

        String message = "Proyecto eliminado con éxito";
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
