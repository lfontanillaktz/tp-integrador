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

    @Autowired
    ProjectService projectService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("employees",employeeService.findAll());
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "/employee/index";
    }

    @PostMapping("/new")
    public String create(@RequestParam(value="name", required = true) String name,@RequestParam(value="lastName", required = true) String lastName,@RequestParam(value="seniority", required = true) Seniority seniority, @RequestParam(value="projectId", required = true) Long projectId){
        employeeService.create(name,lastName,seniority,projectId);
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value="employeeId", required = true) Long id,@RequestParam(value="name", required = true) String name,@RequestParam(value="lastName", required = true) String lastName,@RequestParam(value="seniority", required = true) Seniority seniority, @RequestParam(value="projectId", required = true) Long projectId){
        employeeService.save(id,name,lastName,seniority,projectId);
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value="employeeId") Long id){
        employeeService.delete(id);
        return "redirect:/employee";
    }

}
