package com.kaitzen.service;

import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.repository.EmployeeRepository;
import com.kaitzen.utils.Seniority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional(rollbackOn = Exception.class)
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public void create(String name, String lastName, Seniority seniority, Project project){
        this.save(null, name, lastName, seniority, project);
    }

    public void save(Long id, String name, String lastName, Seniority seniority, Project project){
        Employee employee = null;
        if(id==null){
            employee = new Employee();
        }
        else{
            employee = employeeRepository.findById(id).get();
        }

        employee.setName(name);
        employee.setLastName(lastName);
        employee.setSeniority(seniority);
        employee.setProject(project);
        employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}