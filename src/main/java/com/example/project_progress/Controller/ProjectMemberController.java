package com.example.project_progress.Controller;

import com.example.project_progress.Response.ProjectProgressResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/project-member")
public class ProjectMemberController {

    @GetMapping("/{p_id}")
    public ResponseEntity<?> getAllByProjectID(@PathVariable Long p_id) {
        //List<ProjectProgressResponse> projectProgresses = projectService.getAllByProjectID(p_id);
        String message = "Historial del proyecto obtenidos con éxito";
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        //response.put("projectProgresses", projectProgresses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
