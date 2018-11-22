package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    ClientRepository clientRepository;

    @Transactional(rollbackOn = Exception.class)
    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Project create(String name, Date date, Client client, List<Employee> employees){
        return this.save(null, name, date, client, employees);
    }

    public Project save(Long id, String name, Date date, Client client, List<Employee> employees){
        Project project = null;
        if(id==null){
            project = new Project();
        }
        else{
            project = projectRepository.findById(id).get();
        }

        project.setName(name);
        project.setStartDate(date);
        project.setClient(client);
        project.setEmployees(employees);
        projectRepository.save(project);

        return project;
    }
}
