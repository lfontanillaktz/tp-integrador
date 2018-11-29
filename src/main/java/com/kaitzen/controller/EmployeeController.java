package com.kaitzen.controller;


import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.repository.EmployeeRepository;
import com.kaitzen.service.EmployeeService;
import com.kaitzen.service.ProjectService;
import com.kaitzen.utils.Seniority;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.ValidationEvent;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    ProjectService projectService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String index(Model model){
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects",projects);
        //List<Employee> employees = (List<Employee>) employeeService.findAll();
        model.addAttribute("employees",employeeService.findAll());


        return "/employee/index";
    }

    @PostMapping("/new")
    public String create(@RequestParam (value = "name") String name, @RequestParam(value = "lastName") String lastName,
                         @RequestParam(value = "seniority")Seniority antique, @RequestParam(value = "projectId") Long projectId){
        employeeService.save(null,name,lastName,antique,projectId);
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value = "employeeId") Long employeeId,@RequestParam (value = "name") String name, @RequestParam(value = "lastName") String lastName,
                       @RequestParam(value = "seniority") Seniority antique, @RequestParam (value = "projectId") Long projectId){

        employeeService.save(employeeId,name,lastName,antique,projectId);
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam (value = "employeeId") Long employeeId){

        employeeService.delete(employeeId);
        return "redirect:/employee";
    }
}
