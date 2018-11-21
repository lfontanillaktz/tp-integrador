package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ClientRepository clientRepository;

    public List<Project> findAll(){
        return projectRepository.findAll();
    }


    public void save(Long id, String name, Date date, Long clientId){
        Project project = null;
        if(id == null){
            project = new Project(name,date,clientRepository.findById(clientId).get(),null);
        }
        else{
            project = projectRepository.findById(id).get();
            project.setName(name);
            project.setStartDate(date);
            project.setClient(clientRepository.findById(clientId).get());
        }
        projectRepository.save(project);
    }

    public void delete(Long id){
        projectRepository.deleteById(id);
    }
}