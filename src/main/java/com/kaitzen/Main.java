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

import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    ApplicationRunner run (ClientRepository clientRepository, ProjectRepository projectRepository, EmployeeRepository employeeRepository){
     /* Client client_1 = new Client(  "raul");
       clientRepository.save(client_1);
       Client client_2 = new Client( "raula");
       clientRepository.save(client_2);
       Client client_3 = new Client( "roberto");
       clientRepository.save(client_3);
        Employee employee_1= new Employee("juan","Perez",Seniority.SENIOR);
        employeeRepository.save(employee_1);
        Employee employee_2= new Employee("pedro","diaz",Seniority.ARCHITECT);
        employeeRepository.save(employee_2);
        Employee employee_3= new Employee("martin","juarez",Seniority.SENIOR);
        employeeRepository.save(employee_3);

        Date unafecha= new Date();
        Project proyect_1= new Project("facturacion",unafecha,client_1);
        projectRepository.save(proyect_1);*/
        return null;


    }





}
