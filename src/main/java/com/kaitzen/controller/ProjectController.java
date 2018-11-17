package com.kaitzen.controller;

import com.kaitzen.model.Client;
import com.kaitzen.model.Project;
import com.kaitzen.service.ClientService;
import com.kaitzen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("projects",projectService.findAll());
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "/project/index";
    }

    @PostMapping("/new")
    public String create(@RequestParam(value="name", required = true) String name, @RequestParam(value="date", required = true) String date, @RequestParam(value = "clientId", required = true) Long clientId){
        projectService.create(name, date, clientId);
        return "redirect:/project";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value="projectId") Long id ,@RequestParam(value="name", required = true) String name, @RequestParam(value="date", required = true) String date, @RequestParam(value = "clientId", required = true) Long clientId){
        projectService.save(id, name, date, clientId);
        return "redirect:/project";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value="projectId") Long id){
        projectService.delete(id);
        return "redirect:/project";
    }

}

