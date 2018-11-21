package com.kaitzen.Service;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Modelos.Employee;
import com.kaitzen.Modelos.Project;
import com.kaitzen.Repository.EmployeeRepository;
import com.kaitzen.Repository.ProjectRepository;
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
        return employeeRepository.findAll(); //metodo que trae JpaRepository
    }

    public void save(Long id, String name, String lastName, Seniority seniority, Long projectId){
        Employee employee = null;

        //crear
        if(id==null){
            employee = new Employee();
        }
        else{
            employee = employeeRepository.findById(id).get();
        }

        employee.setName(name);
        employee.setLastName(lastName);
        employee.setSeniority(seniority);

        Project project = projectRepository.findById(projectId).get();
        employee.setProject(project);

        employeeRepository.save(employee);
    }

    public void delete (Long id){
        employeeRepository.deleteById(id);
    }
 }
