package com.kaitzen.controller;


import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
import com.kaitzen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
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

        iniciar(model);

        return "/project/index";

    }

    @PostMapping("/new")
    public String create(@RequestParam(value = "name") String name, @RequestParam(value = "date") String startDate, @RequestParam(value = "clientId") Long clientId) throws ParseException {

        projectService.save(null, name, startDate, clientId);

        return "redirect:/project";

    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value = "projectId") Long projectId, @RequestParam(value = "name") String name, @RequestParam(value = "date") String startDate, @RequestParam(value = "clientId") Long clientId) throws ParseException{

        projectService.save(projectId, name, startDate, clientId);

        return "redirect:/project";

    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "projectId") Long projectId){

        projectService.delete(projectId);

        return "redirect:/project";

    }

    private void iniciar(Model model){

        model.addAttribute("projects",projectService.findAll());
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);

    }


}
