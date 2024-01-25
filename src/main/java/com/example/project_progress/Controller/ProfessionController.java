package com.example.project_progress.Controller;

import com.example.project_progress.Model.Profession;
import com.example.project_progress.Service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService professionService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<Profession> professions = professionService.getAll();
        String message ="Profesiones obtenidas con éxito";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("professions", professions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();

        if( id == null ){
            String message = "No fue enviado el código de la profesión";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        Profession profession = professionService.findById(id);

        if(profession == null){
            String message = "No se encontro la profesión";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        String message = "Profesión obtenida con exito";
        response.put("message", message);
        response.put("projectType", profession);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?>save(@RequestBody Profession profession){

        Map<String, Object> response = new HashMap<>();

        if(profession.getPr_name() == null || profession.getPr_name().isEmpty()){
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        Profession professionFetch = professionService.save(profession);

        if(professionFetch == null){
            String message = "No se pudo crear la profesión";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        String message = "Profesión creada con éxito";
        response.put("message", message);
        response.put("profession", professionFetch);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id ,@RequestBody Profession profession){

        Map<String, Object> response = new HashMap<>();

        if(profession.getPr_name() == null || profession.getPr_name().isEmpty()){
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        Profession professionFetch = professionService.findById(id);

        if(professionFetch == null){
            String message = "No se encontro la profesión";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        professionFetch.setPr_name(profession.getPr_name());

        Profession professionSave = professionService.save(professionFetch);

        if(professionSave == null){
            String message = "No se pudo actualizar la profesión";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        String message = "Profesión creada con éxito";
        response.put("message", message);
        response.put("profession", professionSave);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();

        if( id == null ){
            String message = "No fue enviado el código de el tipo de proyecto";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        Profession professionFetch = professionService.findById(id);

        if(professionFetch == null){
            String message = "No se encontro la profesión";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        professionService.delete(professionFetch);

        String message = "Profesión eliminada con éxito";
        response.put("message", message);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
