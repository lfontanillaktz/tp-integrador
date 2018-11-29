package com.kaitzen.controller;

import com.kaitzen.Modelos.Employee;
import com.kaitzen.Modelos.Project;
import com.kaitzen.Service.EmployeeService;
import com.kaitzen.dto.EmployeeDTO;
import com.kaitzen.dto.ProjectDTO;
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

    @GetMapping("/{id:[\\d]+}") //agregamos la expresion regular: solo numero/s
    public Employee findById (@PathVariable(value = "id") Long id){
        try {
            return employeeService.findById(id);
        }catch (Exception e){
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
    }

    /*@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) //toda peticion http retorna un estado, para creacion debe ser 201 (CREATED)
    public Employee create(@RequestBody EmployeeDTO employeeDTO){
        try {
            return employeeService.save(null, employeeDTO.getName(), employeeDTO.getLastName(),employeeDTO.getSeniority(),employeeDTO.);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Falló la creación del nuevo empleado");
        }
    }

    @PutMapping("/{id:[\\d]+}")
    public Employee edit (@RequestBody ProjectDTO projectDTO,  @PathVariable (value = "id") Long id){
        try{
            return employeeService.save(id, projectDTO.getName(), projectDTO.getStartDate(), projectDTO.getClient());
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Falló la modificación del proyecto");
        }
    }
    */

    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable (value = "id") Long id){
        try{
            employeeService.delete(id);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Falló la eliminación del proyecto");
        }
    }
}
