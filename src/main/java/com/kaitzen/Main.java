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

    @Bean
    ApplicationRunner run(ClientRepository clientRepository, ProjectRepository projectRepository, EmployeeRepository employeeRepository) throws ParseException {

        /*SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date1 = f.parse("14-05-2009");
        Client client_1 = new Client("Raulo");
        clientRepository.save(client_1);
        Project project_1 = new Project("TiraPedos2020", f.parse("23-09-2009"),client_1);
        projectRepository.save(project_1);
        Employee employee_1 = new Employee("Santiago","Cobelli",Seniority.JUNIOR,project_1);
        employeeRepository.save(employee_1);*/

       /* Client client_1 = new Client("Raul");
        clientRepository.save(client_1);


        List<Client> clientRta = clientRepository.findAllByName("raul");
        Client rta = clientRepository.findClientByNameQueryHQL("raul");
        System.out.println(rta.toString());



        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date1 = f.parse("14-05-2009");
        Date date2 = f.parse( "14-05-2010");

        Project project_1 = new Project("TiraPedos2000", f.parse("23-09-2009"),client_1);
        Project project_2 = new Project("JorgeElCurioso", f.parse("05-03-2011"),client_1);
        Project project_3 = new Project("HacedorDeCKKs", f.parse("08-01-2010"),client_1);
        projectRepository.save(project_1);
        projectRepository.save(project_2);
        projectRepository.save(project_3);

        List<Project> proyectRta = projectRepository.findAllByStartDateBetween(date1,date2);
        List<Project> proyectRtaHQL = projectRepository.findProjectByStartDateBetweenQueryHQL(date1, date2);
        List<Project> proyectRtaSQL = projectRepository.findProjectByStartDateBetweenQuerySQL(date1,date2);

        System.out.println(proyectRta.toString());
        System.out.println("***************************************************************************");
        System.out.println(proyectRtaHQL.toString());
        System.out.println("***************************************************************************");
        System.out.println(proyectRtaSQL.toString());
        System.out.println("***************************************************************************");*/



        return null;


    }
}
