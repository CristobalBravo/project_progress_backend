package com.example.project_progress.Controller;

import com.example.project_progress.Model.ProjectState;
import com.example.project_progress.Service.ProjectStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/project-state")
public class ProjectStateController {

    @Autowired
    ProjectStateService projectStateService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<ProjectState> projectStates = projectStateService.getAll();
        String message = "Estados de proyectos obtenidos con éxito";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("projectStates", projectStates);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?> getById(@PathVariable Long pt_id) {

        Map<String, Object> response = new HashMap<>();

        if (pt_id == null) {
            String message = "No fue enviado el código de el estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        ProjectState projectState = projectStateService.findById(pt_id);

        if (projectState == null) {
            String message = "No se encontro el Estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        String message = "Estado de proyecto obtenido con exito";
        response.put("message", message);
        response.put("projectState", projectState);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody ProjectState projectState) {

        Map<String, Object> response = new HashMap<>();

        if (projectState.getPs_name() == null || projectState.getPs_name().isEmpty()) {
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (projectState.getPs_color() == null || projectState.getPs_color().isEmpty()) {
            String message = "El campo color no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        ProjectState projectStateFetch = projectStateService.save(projectState);

        if (projectStateFetch == null) {
            String message = "No se pudo crear el estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        String message = "Estado de proyecto creado con éxito";
        response.put("message", message);
        response.put("projectState", projectStateFetch);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/{pt_id}")
    public ResponseEntity<?> update(@PathVariable Long pt_id, @RequestBody ProjectState projectState) {

        Map<String, Object> response = new HashMap<>();

        if (projectState.getPs_name() == null || projectState.getPs_name().isEmpty()) {
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (projectState.getPs_color() == null || projectState.getPs_color().isEmpty()) {
            String message = "El campo color no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        ProjectState projectStateFetch = projectStateService.findById(pt_id);

        if (projectStateFetch == null) {
            String message = "No se encontro el estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        projectStateFetch.setPs_name(projectState.getPs_name());
        projectStateFetch.setPs_color(projectState.getPs_color());

        ProjectState projectStateSave = projectStateService.save(projectStateFetch);

        if (projectStateSave == null) {
            String message = "No se pudo actualizar el estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        String message = "Estado de proyecto creado con éxito";
        response.put("message", message);
        response.put("projectState", projectStateSave);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> delete(@PathVariable Long pt_id) {

        Map<String, Object> response = new HashMap<>();

        if (pt_id == null) {
            String message = "No fue enviado el código de el estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        ProjectState projectStateFetch = projectStateService.findById(pt_id);

        if (projectStateFetch == null) {
            String message = "No se encontro el estado de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        projectStateService.delete(projectStateFetch);

        String message = "Estado de proyecto eliminado con éxito";
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
