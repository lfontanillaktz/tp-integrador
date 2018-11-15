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
    public String index(Model model){
        setEmployees(model);
        return "employee/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName,
                         @RequestParam(value = "seniority")Seniority seniority, @RequestParam(value = "projectId") Long projectId){

        employeeService.save(null, name, lastName, seniority, projectId);
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String edit(Model model, @RequestParam(value = "employeeId") Long id ,@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName,
                         @RequestParam(value = "seniority")Seniority seniority, @RequestParam(value = "projectId") Long projectId){
        employeeService.save(id, name, lastName, seniority, projectId);
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam(value = "employeeId") Long id){
        employeeService.delete(id);
        return "redirect:/employee";
    }


    private void setEmployees(Model model){
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("projects", projectService.findAll());
    }

}
