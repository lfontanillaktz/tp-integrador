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

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    ApplicationRunner run(ClientRepository clientRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository) throws ParseException {
        Client cliente1= new Client("juan");
        clientRepository.save(cliente1);
        Client cliente2= new Client("jose");
        clientRepository.save(cliente2);



        Project project = new Project("proyecto",new Date(5,5,5),cliente1,null);
        Employee employee = new Employee("juan","alpaca",Seniority.SENIOR,null);

        employee.setProject(project);

        List<Employee> lista = new ArrayList<Employee>();
        lista.add(employee);

        project.setEmployees(lista);

        projectRepository.save(project);
        employeeRepository.save(employee);

        // print lista clientes llamados juan

      List<Client> clientRta = clientRepository.findAllByName("juan");
      System.out.println("***********************************************************************************");
      System.out.println(clientRta.get(0).getName());


        // print cliente llamado juan por consulta HQL
      System.out.println("***********************************************************************************");
      System.out.println(clientRepository.findClientByNameQueryHQL("juan").getName());
        // print cliente llamado juan por consulta SQL
      System.out.println("***********************************************************************************");
      System.out.println(clientRepository.findClientByNameQuerySQL("juan").getName());

      //print proyecto con startDate entre 2 fechas
      System.out.println("***********************************************************************************");
      Date stDate = new Date(1,1,1);
      Date edDate = new Date(8,8,8);
      System.out.println(projectRepository.findAllByStartDateIsBetween(stDate,edDate).get(0).getName());
      System.out.println(projectRepository.findProjectByStartDateIsBetweenQueryHQL(stDate,edDate).getName());
      System.out.println(projectRepository.findProjectByStartDateIsBetweenQuerySQL(stDate,edDate).getName());


        return null;
    }
}

