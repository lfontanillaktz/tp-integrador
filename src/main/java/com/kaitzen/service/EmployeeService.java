package com.kaitzen.service;

import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
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

    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public Employee save(Long id, String name, String lastName, Seniority seniority, Long projectId){
        Employee employee = null;
        if(id == null){
            employee = new Employee(name,lastName,seniority,projectRepository.findById(projectId).get());
        }
        else{
            employee = employeeRepository.findById(id).get();
            employee.setName(name);
            employee.setLastName(lastName);
            employee.setSeniority(seniority);
            employee.setProject(projectRepository.findById(projectId).get());
        }
        employeeRepository.save(employee);
        return employee;
    }
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
