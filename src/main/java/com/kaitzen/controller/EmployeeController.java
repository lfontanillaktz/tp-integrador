package com.kaitzen.controller;

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

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectService projectService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "/employee/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("seniority") Seniority seniority, @RequestParam("projectId") Long projectId){

        employeeService.save(null,name,lastName,seniority,projectId);
        model.addAttribute("employees", employeeService.findAll());
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String edit(Model model,@RequestParam("employeeId") Long employeeId, @RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("seniority") Seniority seniority, @RequestParam("projectId") Long projectId){
        employeeService.save(employeeId,name,lastName,seniority,projectId);
        model.addAttribute("employees", employeeService.findAll());
        return "redirect:/employee";
    }
}
