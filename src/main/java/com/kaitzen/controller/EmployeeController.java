package com.kaitzen.controller;


import com.kaitzen.model.Project;
import com.kaitzen.service.EmployeeService;
import com.kaitzen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectService projectService;

    @GetMapping
    public String index(Model model){

        iniciar(model);

        return "/employee/index";
    }

    @PostMapping("/new")
    public String create(@RequestParam(value = "name") String name,@RequestParam(value = "lastName") String lastname, @RequestParam(value = "seniority") String seniority, @RequestParam(value = "projectId") Long projectId){

        employeeService.save(null, name, lastname, seniority, projectId);

        return "redirect:/employee";

    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value = "employeeId") Long id, @RequestParam(value = "name") String name,@RequestParam(value = "lastName") String lastname, @RequestParam(value = "seniority") String seniority, @RequestParam(value = "projectId") Long projectId){

        employeeService.save(id, name, lastname, seniority, projectId);

        return "redirect:/employee";

    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "employeeId") Long id){

        employeeService.delete(id);

        return "redirect:/employee";

    }

    private void iniciar(Model model){

        model.addAttribute("employees", employeeService.findAll());
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        System.out.println(projects.get(0).getName());

    }

}
