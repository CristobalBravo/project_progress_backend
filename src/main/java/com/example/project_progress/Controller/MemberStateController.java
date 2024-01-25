package com.example.project_progress.Controller;

import com.example.project_progress.Model.MemberState;
import com.example.project_progress.Service.MemberStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/member-state")
public class MemberStateController {

    @Autowired
    private MemberStateService memberStateService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<MemberState> memberStates = memberStateService.getAll();
        String message ="Estado de los miembros obtenidos con éxito";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("memberStates", memberStates);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();

        if( id == null ){
            String message = "No fue enviado el código del miembro";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        MemberState memberState = memberStateService.findById(id);

        if(memberState == null){
            String message = "No se encontro el miembro";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        String message = "Miembro obtenido con exito";
        response.put("message", message);
        response.put("memberState", memberState);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?>save(@RequestBody MemberState memberState){

        Map<String, Object> response = new HashMap<>();

        if(memberState.getMs_name() == null || memberState.getMs_name().isEmpty()){
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        MemberState memberStateFetch = memberStateService.save(memberState);

        if(memberStateFetch == null){
            String message = "No se pudo crear el estado del miembro";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        String message = "Estado del miembro creado con éxito";
        response.put("message", message);
        response.put("memberState", memberStateFetch);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id ,@RequestBody MemberState memberState){

        Map<String, Object> response = new HashMap<>();

        if(memberState.getMs_name() == null || memberState.getMs_name().isEmpty()){
            String message = "El campo nombre no puede estar vácio";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        MemberState memberStateFetch = memberStateService.findById(id);

        if(memberStateFetch == null){
            String message = "No se encontro el estado del miembro";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        memberStateFetch.setMs_name(memberState.getMs_name());

        MemberState memberStateSave = memberStateService.save(memberStateFetch);

        if(memberStateSave == null){
            String message = "No se pudo actualizar el estado del miembro";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        String message = "Miembro editado con éxito";
        response.put("message", message);
        response.put("memberState", memberStateSave);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();

        if( id == null ){
            String message = "No fue enviado el código de el estado del miembro";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

        MemberState memberStateFetch = memberStateService.findById(id);

        if(memberStateFetch == null){
            String message = "No se encontro el estado del miembro";
            response.put("message", message);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        memberStateService.delete(memberStateFetch);

        String message = "Estado de miembro eliminado con éxito";
        response.put("message", message);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
