package com.kaitzen.controller;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Modelos.Project;
import com.kaitzen.Service.ClientService;
import com.kaitzen.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    ClientService clientService;

    @GetMapping
    public String index(Model model){
        List<Project> projectList = projectService.findAll();
        model.addAttribute("projects", projectList);
        List<Client> clientList = clientService.findAll(); //se setea todo de una, los pop ups estan pero no se ven, igual hay que setearle las listas que contengan
        model.addAttribute("clients", clientList);
        return "/project/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam(value = "name") String name, @RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam(value = "clientId") Long clientId){



        projectService.save(null, name, startDate, clientId);

        return "redirect:/project";
    }
}
