package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ClientRepository clientRepository;

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public void save(Long id, String name, Date startDate, Long clientId){
        Project project;
        if(id == null){
            project = new Project();
        }else{
            project = projectRepository.findById(id).get();
        }
        project.setClient(clientRepository.findById(clientId).get());
        project.setName(name);
        project.setStartDate(startDate);
        projectRepository.save(project);
    }


    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    public Project findById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.isPresent() ? project.get() : null;
    }
}
