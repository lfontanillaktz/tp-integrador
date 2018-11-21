package com.kaitzen.controller;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Modelos.Project;
import com.kaitzen.Service.ProjectService;
import com.kaitzen.dto.ClientDTO;
import com.kaitzen.dto.ProjectDTO;
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

    @GetMapping("/{id:[\\d]+}") //agregamos la expresion regular: solo numero/s
    public Project findById (@PathVariable(value = "id") Long id){
        try {
            return projectService.findById(id);
        }catch (Exception e){
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) //toda peticion http retorna un estado, para creacion debe ser 201 (CREATED)
    public Project create(@RequestBody ProjectDTO projectDTO){
        try {
            return projectService.save(null, projectDTO.getName(),projectDTO.getStartDate(),projectDTO.getClient());
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Falló la creación del nuevo proyecto");
        }
    }
}
