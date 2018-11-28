package com.kaitzen.controller;

import com.kaitzen.dto.ProjectDTO;
import com.kaitzen.model.Project;
import com.kaitzen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/project")
public class RestProjectController {

    @Autowired
    ProjectService projectService;
    @GetMapping
    public List<Project> findAll(){
        return projectService.findAll();
    }

    @GetMapping("/{id:[\\d]+}")
    public Project findById(@PathVariable(value= "id") Long id){
        return projectService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project create(@RequestBody ProjectDTO projectDTO){
       try {
            Project project = projectService.save(null, projectDTO.getName(), projectDTO.getDate(), projectDTO.getClientId());
            return project;
       }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id:[\\d]+}")
    public Project edit(@RequestBody ProjectDTO projectDTO, @PathVariable(value = "id") Long id){
        try {
            Project project = projectService.save(id, projectDTO.getName(),projectDTO.getDate(),projectDTO.getClientId());
            return project;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable(value = "id") Long id){
        projectService.delete(id);
    }
}
