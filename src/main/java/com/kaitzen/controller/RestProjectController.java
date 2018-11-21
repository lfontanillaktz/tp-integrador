package com.kaitzen.controller;

import com.kaitzen.ClientDTO.ProjectDTO;
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
    public List<Project>findAll(){
        List<Project>projects=projectService.findAll();
        return projects;
    }

    @GetMapping("/{id:[\\d]+}")
    public Project findById(@PathVariable(value = "id") Long id){
        Project project = projectService.findById(id);
        if(project == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return project;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Project create(@RequestBody ProjectDTO projectDTO){
        try {
            Project project = projectService.create(projectDTO.getName(), projectDTO.getStartDate(), projectDTO.getClientId());
            return project;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Creation failure");
        }
    }

    @PutMapping("/{id:[\\d]+}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Project edit(@RequestBody ProjectDTO projectDTO, @PathVariable(value = "id") Long id){
        try {
            Project project = projectService.save(id, projectDTO.getName(), projectDTO.getStartDate(), projectDTO.getClientId());
            return project;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Edition failure");
        }
    }

    @DeleteMapping("/{id:[\\d]+}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable(value = "id") Long id){
        try {
            projectService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Deletion failure");
        }
    }
}
