package com.kaitzen.service;


import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.EmployeeRepository;
import com.kaitzen.repository.ProjectRepository;
import com.kaitzen.utils.Seniority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    public List<Employee> findAll(){

        return employeeRepository.findAll();

    }

    public void save(Long id, String name, String lastName, String seniority, Long projectId){

        Employee empleado = null;

        if(id == null){

            empleado = new Employee();

        }else{

            empleado = employeeRepository.findById(id).get();

        }

        Project proyecto = projectRepository.findById(projectId).get();
        empleado.setName(name);
        empleado.setLastName(lastName);
        System.out.println("primero");
        empleado.setSeniority(Seniority.valueOf(seniority));
        System.out.println("Segundo");
        empleado.setProject(proyecto);
        System.out.println("Tercero");
        employeeRepository.save(empleado);
        System.out.println("Cuarto");


    }

    public void delete(Long id){

        employeeRepository.deleteById(id);

    }


}
