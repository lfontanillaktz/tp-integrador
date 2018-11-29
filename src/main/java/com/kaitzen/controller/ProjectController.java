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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping ("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ClientService clientService;

    @GetMapping
    public String index(Model model){

        List<Client> clients = clientService.findAll();
        model.addAttribute("clients",clients);
        model.addAttribute("projects",projectService.findAll());
        return "/project/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam(value = "name") String name,@RequestParam(value = "date") String date,@RequestParam(value = "clientId") Long clientId) throws ParseException {

            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date starDate = f.parse(date);
            projectService.save(null, name,starDate,clientId);

        return "redirect:/project";

    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value = "projectId") Long id, @RequestParam(value = "name") String name,@RequestParam(value = "date") String date,@RequestParam(value = "clientId") Long clientId) throws ParseException {

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date starDate = f.parse(date);
        projectService.save(id,name,starDate,clientId);

        return "redirect:/project";

    }

    @PostMapping("/delete")
    public String edit(@RequestParam(value = "projectId") Long id) {
        projectService.delete(id);

        return "redirect:/project";
    }


}
