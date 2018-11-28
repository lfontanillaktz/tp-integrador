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
import java.text.SimpleDateFormat;
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
        setProjects(model);
        return "/project/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam(value = "name") String name, @RequestParam(value = "date")String stringDate,
                         @RequestParam(value = "clientId") Long clientId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Fecha: "+stringDate);
        }
        projectService.save(null, name, date, clientId);
        return "redirect:/project";
    }

    @PostMapping("/edit")
    public String edit(Model model, @RequestParam(value = "projectId") Long id, @RequestParam(value = "name") String name,
                       @RequestParam(value = "date")String stringDate, @RequestParam(value = "clientId") Long clientId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Fecha: "+stringDate);
        }
        projectService.save(id, name, date, clientId);
        return "redirect:/project";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam(value = "projectId") Long id){
        projectService.delete(id);
        return "redirect:/project";
    }


    private void setProjects(Model model){
        model.addAttribute("projects", projectService.findAll());
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
//        System.out.println(clientes);
    }

}
