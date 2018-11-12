package com.kaitzen;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.EmployeeRepository;
import com.kaitzen.repository.ProjectRepository;
import com.kaitzen.utils.Seniority;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }

    @Bean
    ApplicationRunner run(ClientRepository clientRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository){
       //inserta en la base raul
        Client client1 = new Client("raul");
        clientRepository.save(client1);

        //crea cliente franco
        Client client2 = new Client("franco");
        clientRepository.save(client2);
        //crea 2 empleados
        Employee employee1 = new Employee("gonzalo","garcia aguirre", Seniority.SEMI_SENIOR,null);
        Employee employee2 = new Employee("franco","pizzutti", Seniority.SENIOR,null);
        //crea lista empleados
        List<Employee> empleadosList = new ArrayList<>();
        empleadosList.add(employee1);
        empleadosList.add(employee2);
        //crea proyecto
        Project project1 = new Project("proyecto1",new Date(10,10,10),client1,empleadosList);

        //saves
        projectRepository.save(project1);
        employee1.setProject(project1);
        employee2.setProject(project1);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        //levanta de la base raul
        System.out.println("**************************** RTAS ************************************");
        List<Client> clientRta = clientRepository.findAllByName("raul");
        System.out.println(clientRta.get(0).getName());

        //levanta proyecto1 con hql
        Project projectRta = projectRepository.findProjectByStartDateIsBetweenQueryHQL(new Date(10,9,10), new Date(10,12,10));
        System.out.println(projectRta.getName());

        //levanta proyecto1 con sql
        Project projectRta2=projectRepository.findProjectByStartDateIsBetweenQuerySQL(new Date(10,9,10),new Date(10,12,10));
        System.out.println(projectRta2.getName());
        System.out.println("**************************** FIN RTAS ************************************");

        return null;
    }

}
