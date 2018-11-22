package com.kaitzen.controller;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.service.ProjectService;
import com.kaitzen.service.ClientService;
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

    @GetMapping
    public String index(Model model){
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);

        return "/project/index";
    }

    @PostMapping("/new")
    public String create(@RequestParam(value = "projectName") String name, @RequestParam(value = "projectDate") Date date, @RequestParam(value = "projectClient")Client client, @RequestParam(value = "projectEmployees")List<Employee> employees){
        projectService.create(name, date, client, employees);
        return "redirect:/project";
    }


}
