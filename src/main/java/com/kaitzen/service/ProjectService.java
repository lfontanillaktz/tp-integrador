package com.kaitzen.service;


import com.kaitzen.model.Client;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

    public Project findById(Long id) {

        Optional<Project> project = projectRepository.findById(id);
        return project.isPresent() ? project.get() : null;

    }

    public Project save(Long id, String name, String startDate, Long clientId) throws ParseException {


        Project project = null;

        if(id == null){

            project = new Project();

        }else{

            project = projectRepository.findById(id).get();

        }

        Client client = clientRepository.findById(clientId).get();
        project.setName(name);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = f.parse(startDate);
        project.setStartDate(date);
        project.setClient(client);
        projectRepository.save(project);

        return project;

    }

    public void delete(Long id){

        projectRepository.deleteById(id);

    }

}
