package com.kaitzen.controller;

import com.kaitzen.model.Project;
import com.kaitzen.service.EmployeeService;
import com.kaitzen.service.ProjectService;
import com.kaitzen.utils.Seniority;
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

    @GetMapping
    public String index(Model model){
        model.addAttribute("employees", employeeService.findAll());
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects",projects);
        return "/employee/index";
    }

    @Autowired
    ProjectService projectService;
    @PostMapping("/new")
    public String create(Model model, @RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("seniority") Seniority seniority, @RequestParam("projectId") Long projectId){
        model.addAttribute("employees", employeeService.findAll());
        employeeService.save(null,name,lastName,seniority,projectId);
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String edit(Model model,@RequestParam("employeeId") Long employeeId, @RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("seniority") Seniority seniority, @RequestParam("projectId") Long projectId){
        employeeService.save(employeeId,name,lastName,seniority,projectId);
        model.addAttribute("employees", employeeService.findAll());
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public void delete(Model model, @RequestParam("employeeId") Long employeeId){
        employeeService.delete(employeeId);
    }
}
