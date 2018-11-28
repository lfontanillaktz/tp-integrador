package com.kaitzen.controller;

import com.kaitzen.dto.ProjectDto;
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
        List<Project> employees = projectService.findAll();
        return employees;
    }
    @GetMapping("/{id:[\\d]+}")
    public Project findById(@PathVariable(value="id") Long id){
        Project p = projectService.findById(id);
        if(p==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            return p;
        }
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Project create(@RequestBody ProjectDto projectDto){
        try{
            Project project = projectService.save(null,projectDto.getName(),projectDto.getStartDate(),projectDto.getClient().getId());
            return project;
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Creation failed");
        }
    }

    @PutMapping("/{id:[\\d]+}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Project edit(@PathVariable("id") Long id, @RequestBody ProjectDto projectDto){
        try{
            Project project = projectService.save(id,projectDto.getName(),projectDto.getStartDate(),projectDto.getClient().getId());
            return project;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Edition failed");
        }
    }

    @DeleteMapping("/{id:[\\d]+}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id){
        try{
            projectService.delete(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Delete failed");
        }

    }
}
