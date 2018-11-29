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
    public List<Project> findAll() {

        List<Project> projects = projectService.findAll();
        return projects;

    }

    @GetMapping("/{id:[\\d]+}")
    public Project findByID(@PathVariable(value = "id") Long id) {

        Project project = projectService.findById(id);

        if(project == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");

        }

        return project;

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Project create(@RequestBody ProjectDTO projectDTO) {

        System.out.println(projectDTO.getName());
        System.out.println(projectDTO.getStarDate());
        System.out.println(projectDTO.getClientId());
        System.out.println("Entro al Post");

        try {
            System.out.println("Entro a crearlo");
            Project project = projectService.save(null , projectDTO.getName(), projectDTO.getStarDate(), projectDTO.getClientId());
            return project;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Creation Fails");
        }

    }

}
