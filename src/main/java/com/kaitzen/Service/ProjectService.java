package com.kaitzen.Service;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Modelos.Project;
import com.kaitzen.Repository.ClientRepository;
import com.kaitzen.Repository.ProjectRepository;
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
        return projectRepository.findAll(); //metodo proporcionado por JpaRepository
    }

    public void save (Long id, String name, Date startDate, Long clientId){
        Project project = null;

        //crear
        if(id== null){
            project = new Project();
        }
        else{
            project = projectRepository.findById(id).get();
        }

        project.setName(name);
        project.setStartDate(startDate);

        Client client = clientRepository.findById(clientId).get();
        project.setClient(client);

        projectRepository.save(project);

    }

    //save para rest
    public Project save (Long id, String name, Date startDate, Client client){
        Project project = null;

        //crear
        if(id== null){
            project = new Project();
        }
        else{
            project = projectRepository.findById(id).get();
        }

        project.setName(name);
        project.setStartDate(startDate);
        project.setClient(client);

        return projectRepository.save(project);

    }

    public Project findById(Long id) {
        return projectRepository.findById(id).get();
    }
}
