package com.kaitzen.repository;

import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.utils.Seniority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    List<Employee> findAllByName(String name);
    List<Employee> findAllByLastName(String lastName);
    List<Employee> findAllBySeniority(Seniority sen);
    List<Employee> findAllByProject(Project project);
}
