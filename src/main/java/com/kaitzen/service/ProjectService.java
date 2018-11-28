package com.kaitzen.service;

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

    public Project findById(Long id){
      Optional<Project> result = projectRepository.findById(id);
      if(result.isPresent()){
          return result.get();
      }
      else return null;
    }

    public Project save(Long id, String name, Date date, Long clientId){
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
        return project;
    }

    public void delete(Long id){
        projectRepository.deleteById(id);
    }
}