package com.kaitzen;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.EmployeeRepository;
import com.kaitzen.repository.ProjectRepository;
import com.kaitzen.utils.Seniority;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

//    @Bean
//    ApplicationRunner run(ClientRepository clientRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository){
//
//
//        Project project_1 = new Project("Proyecto 3", new Date(2005, 6, 3));
//        projectRepository.save(project_1);
//        Project project_2 = new Project("Proyecto 4", new Date(2015, 3, 25));
//        projectRepository.save(project_2);
//        Project project_3 = new Project("Proyecto 5", new Date(2010, 5, 8));
//        projectRepository.save(project_3);
//        Project project_4 = new Project("Proyecto 6", new Date(1998, 4, 10));
//        projectRepository.save(project_4);
//
//        System.out.println("Spring: "+projectRepository.findByStartDateBetween(LocalDate.of(2000, 1, 1), LocalDate.of(2016, 1, 1)));
//        System.out.println("JPQL: "+projectRepository.findByStartDateBetweenJPQL(LocalDate.of(2000, 1, 1), LocalDate.of(2016, 1, 1)));
//        System.out.println("SQL: "+projectRepository.findByStartDateBetweenSQL(LocalDate.of(2000, 1, 1), LocalDate.of(2016, 1, 1)));
//
//        return null;
//    }

}