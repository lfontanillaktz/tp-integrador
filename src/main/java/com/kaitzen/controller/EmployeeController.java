package com.kaitzen.controller;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Modelos.Employee;
import com.kaitzen.Modelos.Project;
import com.kaitzen.Repository.EmployeeRepository;
import com.kaitzen.Service.EmployeeService;
import com.kaitzen.Service.ProjectService;
import com.kaitzen.utils.Seniority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Contended;

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
        //busca todos los clientes desde la BD
        List<Employee> employeeList = employeeService.findAll();
        //pone la lista de usuarios traida de la BD en pantalla
        model.addAttribute("employees", employeeList); //el "clients" hace referencia a la lista definida en el index

        //busca la lista de proyectos
        List<Project> projectList = projectService.findAll();
        model.addAttribute("projects", projectList);

        return "/employee/index"; //posiciona dentro de la carpeta templates el archivo index.html
    }

    @PostMapping("/new")
    public String create (Model model, @RequestParam(value = "name") String  name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "seniority")Seniority seniority, @RequestParam(value = "projectId") Long projectId){

        employeeService.save(null, name, lastName, seniority, projectId);
        //volvemos a la pantalla /employee
        return "redirect:/employee";
    }
}
