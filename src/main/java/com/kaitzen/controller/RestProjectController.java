package com.kaitzen.controller;

import com.kaitzen.model.Project;
import com.kaitzen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sun.java2d.loops.ProcessPath;

import java.util.List;

@RestController
@RequestMapping("/rest/project")
public class RestProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> findAll(){
        List<Project> projects = projectService.findAll();
        return projects;
    }

    @GetMapping("/{id:[\\d]+}")
    public Project findById(@PathVariable("id") Long id){
        Project project = projectService.findById(id);

        if(project == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
        }

        return project;
    }


}
