package com.kaitzen.controller;


import com.kaitzen.dto.EmployeeDTO;
import com.kaitzen.model.Employee;
import com.kaitzen.service.EmployeeService;
import com.kaitzen.utils.Seniority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/employee")
public class RestEmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }


    @GetMapping("/{id:[\\d]+}")
    public Employee findById(@PathVariable(value = "id") Long id){
        return employeeService.findById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee create(@RequestBody EmployeeDTO employeeDTO){
       try {
           Employee employee = employeeService.save(null, employeeDTO.getName(), employeeDTO.getLastName(), employeeDTO.getSeniority(), employeeDTO.getProjectId());
           return employee;
       }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Create fails");
        }
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id:[\\d]+}")
    public Employee edit(@RequestBody EmployeeDTO employeeDTO, @PathVariable(value = "id") Long id){
        try {
        Employee employee = employeeService.save(id,employeeDTO.getName(),employeeDTO.getLastName(),employeeDTO.getSeniority(),employeeDTO.getProjectId());
            return employee;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Edit fails");
        }
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable(value="id") Long id){
        employeeService.delete(id);
    }

}
