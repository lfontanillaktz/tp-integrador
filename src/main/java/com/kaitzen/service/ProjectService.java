package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ClientService clientService;

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public void create(String name, String date, Long clientId){
        this.save(null, name, date, clientId);
    }

    public void save(Long id, String name, String date, Long clientId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date1 = sdf.parse(date);
            //System.out.println(date);
            Project project = null;
            if(id==null){
                project = new Project();
            }
            else{
                project = projectRepository.findById(id).get();
            }
            Client client = clientService.findById(clientId);
            project.setName(name);
            project.setStartDate(date1);
            project.setClient(client);
            projectRepository.save(project);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id){
        projectRepository.deleteById(id);
    }

}
