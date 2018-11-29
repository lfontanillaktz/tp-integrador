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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

/*
    @Bean
    ApplicationRunner run(ClientRepository clientRepository, ProjectRepository projectRepository, EmployeeRepository employeeRepository) throws ParseException {

        Client client_1 = new Client("Emanuel");
        clientRepository.save(client_1);

        Client client_2 = new Client("Sergio");
        clientRepository.save(client_2);

        List<Client> clientRta = clientRepository.findAllByName("Emanuel");
        System.out.println(clientRta.get(0).getName());

        Client clientRta2 = clientRepository.findClientByNameQueryHQL("Emanuel");
        System.out.println(clientRta2.getName());

        Client clientRta3 = clientRepository.findClientByNameQuerySQL("Emanuel");
        System.out.println(clientRta3.getName());

        //Projecto

        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date1 = f.parse("18-11-1997");
        Project project_1 = new Project("Projecto1", date1);
        projectRepository.save(project_1);

        Date date2 = f.parse("18-12-1997");
        Project project_2 = new Project("Projecto2", date2);
        projectRepository.save(project_2);

        Date date3 = f.parse("10-02-1998");
        Project project_3 = new Project("Projecto3", date3);
        projectRepository.save(project_3);

        List<Project> proyectosRta1 = projectRepository.findByStartDateBetween(date1,date3);

        for(Project i : proyectosRta1){

            System.out.println(proyectosRta1.get(0).getName());

        }

        List<Project> proyectosRta2 = projectRepository.findClientByNameQuerySQL(date1,date3);

        for(Project i : proyectosRta2){

            System.out.println(proyectosRta2.get(0).getName());

        }

        List<Project> proyectosRta3 = projectRepository.findProjectByStartDateBetweenHQL(date1,date3);

        for(Project i : proyectosRta3){

            System.out.println(proyectosRta3.get(0).getName());

        }




        //Empleado
        Project proyecto = null;
        Employee empleado1 = new Employee("Emanuel", "Tomas", Seniority.SENIOR, proyecto);
        employeeRepository.save(empleado1);


        return null;

    }
*/

}