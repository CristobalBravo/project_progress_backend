package com.example.project_progress.Controller;

import com.example.project_progress.Model.ProjectType;
import com.example.project_progress.Service.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/project-type")
public class ProjectTypeController {

    @Autowired
    ProjectTypeService projectTypeService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<ProjectType> projectTypes = projectTypeService.getAll();
        String message ="Tipos de proyectos obtenidos con éxito";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("projectTypes", projectTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?>getById(@PathVariable Long pt_id){

        Map<String, Object> response = new HashMap<>();

        if( pt_id == null ){
            String message = "No fue enviado el código de el tipo de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        ProjectType projectType = projectTypeService.findById(pt_id);

        if(projectType == null){
            String message = "No se encontro el tipo de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        String message = "Tipo de proyecto obtenido con exito";
        response.put("message", message);
        response.put("projectType", projectType);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?>save(@RequestBody ProjectType projectType){

        Map<String, Object> response = new HashMap<>();

        if(projectType.getPt_name() == null || projectType.getPt_name().isEmpty()){
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        ProjectType projectTypeFetch = projectTypeService.save(projectType);

        if(projectTypeFetch == null){
            String message = "No se pudo crear el usuario";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        String message = "Tipo de proyecto creado con éxito";
        response.put("message", message);
        response.put("projectType", projectTypeFetch);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PutMapping("/{pt_id}")
    public ResponseEntity<?>update(@PathVariable Long pt_id ,@RequestBody ProjectType projectType){

        Map<String, Object> response = new HashMap<>();

        if(projectType.getPt_name() == null || projectType.getPt_name().isEmpty()){
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        ProjectType projectTypeFetch = projectTypeService.findById(pt_id);

        if(projectTypeFetch == null){
            String message = "No se encontro el tipo de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        projectTypeFetch.setPt_name(projectType.getPt_name());

        ProjectType projectTypeSave = projectTypeService.save(projectTypeFetch);

        if(projectTypeSave == null){
            String message = "No se pudo actualizar el usuario";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        String message = "Tipo de proyecto creado con éxito";
        response.put("message", message);
        response.put("projectType", projectTypeSave);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?>delete(@PathVariable Long pt_id){

        Map<String, Object> response = new HashMap<>();

        if( pt_id == null ){
            String message = "No fue enviado el código de el tipo de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        ProjectType projectTypeFetch = projectTypeService.findById(pt_id);

        if(projectTypeFetch == null){
            String message = "No se encontro el tipo de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        projectTypeService.delete(projectTypeFetch);

        String message = "Tipo de proyecto eliminado con éxito";
        response.put("message", message);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
