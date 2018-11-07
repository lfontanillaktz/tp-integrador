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
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Bean
    ApplicationRunner run(ClientRepository clientRepository, ProjectRepository projectRepository, EmployeeRepository employeeRepository) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        /*Client client_1 = new Client("Guille");
        clientRepository.save(client_1);
        Client client_2 = new Client("Ema");
        clientRepository.save(client_2);
        Client client_3 = new Client("Lucho");
        clientRepository.save(client_3);

        Date date = sdf.parse("10-01-2018");
        Project project_1 = new Project("Project_1", date);
        project_1.setClient(client_1);
        projectRepository.save(project_1);
        date = sdf.parse("10-04-2018");
        Project project_2 = new Project("Project_2", date);
        project_2.setClient(client_2);
        projectRepository.save(project_2);
        date = sdf.parse("10-08-2018");
        Project project_3 = new Project("Project_3", date);
        project_3.setClient(client_3);
        projectRepository.save(project_3);

        Employee employee_1 = new Employee("Lucho","Ballatore", Seniority.JUNIOR,project_1);
        employeeRepository.save(employee_1);
        Employee employee_2 = new Employee("Malena","Moix", Seniority.SOFTWARE_DESIGNER,project_2);
        employeeRepository.save(employee_2);
        Employee employee_3 = new Employee("Maca","Moya", Seniority.SENIOR,project_3);
        employeeRepository.save(employee_3);*/

       /*List<Client> clientes = clientRepository.findAllByName("Guille");

        System.out.println(clientes.get(0).getName());*/

        /*Client client_1 = new Client("Carla");
        clientRepository.save(client_1);
        Client cliente = clientRepository.findClientByNameQueryHQL("Carla");

        System.out.println(cliente.getName());*/
        Date date1 = sdf.parse("10-03-2018");
        Date date2 = sdf.parse("10-05-2018");
        /*List<Project> projectos = projectRepository.findByStartDateBetween(date1,date2);
        for(Project project : projectos){
            System.out.println(project.getId()+": "+project.getName());
        }*/

        List<Project> projectos = projectRepository.findProjectByStartDateBetweenQuerySQL(date1,date2);
        for(Project project : projectos){
            System.out.println(project.getId()+": "+project.getName());
        }

        return null;
    }

}
