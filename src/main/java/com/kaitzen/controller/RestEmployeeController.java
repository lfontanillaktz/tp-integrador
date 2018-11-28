package com.kaitzen.controller;

import com.kaitzen.dto.EmployeeDto;
import com.kaitzen.model.Employee;
import com.kaitzen.service.EmployeeService;
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
        List<Employee> employees = employeeService.findAll();
        return employees;
    }
    @GetMapping("/{id:[\\d]+}")
    public Employee findById(@PathVariable(value="id") Long id){
        Employee e = employeeService.findById(id);
        if(e==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            return e;
        }
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee create(@RequestBody EmployeeDto employeeDTO){
        try{
            Employee employee = employeeService.save(null, employeeDTO.getName(),employeeDTO.getLastname(),employeeDTO.getSeniority(),employeeDTO.getProject().getId());
            return employee;
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Creation failed");
        }
    }

    @PutMapping("/{id:[\\d]+}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Employee edit(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto){
        try{
            Employee employee = employeeService.save(id,employeeDto.getName(),employeeDto.getLastname(),employeeDto.getSeniority(),employeeDto.getProject().getId());
            return employee;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Edition failed");
        }
    }

    @DeleteMapping("/{id:[\\d]+}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id){
        try{
            employeeService.delete(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Delete failed");
        }

    }

}
