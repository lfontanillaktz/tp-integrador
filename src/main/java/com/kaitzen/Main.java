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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {SpringApplication.run(Main.class, args);}

    @Bean
    ApplicationRunner run(ClientRepository clientRepository, ProjectRepository projectRepository, EmployeeRepository employeeRepository){
       /* Client client_1=new Client("Gustavo");
        Client client_2=new Client("Jorge");
        Client client_3=new Client("Ramón");

        clientRepository.save(client_1);
        clientRepository.save(client_2);
        clientRepository.save(client_3);

      List<Client> response= clientRepository.findAllByName("Jorge");
        System.out.println("**********************************************************");
       System.out.println(response.get(0).toString());
        System.out.println("**********************************************************");

        List<Client> clienterta= clientRepository.findClientByNameQuerySQL("Ramón");

      List<Client> listaClientes=clientRepository.findAll();

        SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date fecha1=f.parse("25/02/2018");
        Date fecha2=f.parse("25/06/2018");
        Date fecha3=f.parse("25/02/2019");

        Date fechaInicio=f.parse("01/06/2018");
        Date fechaFin=f.parse("31/12/2018");


        Project project_1=new Project("Proyecto1", fecha1, listaClientes.get(0));
        Project project_2=new Project("Proyecto2", fecha2, listaClientes.get(1));
        Project project_3=new Project("Proyecto3", fecha3, listaClientes.get(2));

        projectRepository.save(project_1);
        projectRepository.save(project_2);
        projectRepository.save(project_3);

        Employee employee_1=new Employee("Empleado1","Empleado1Apellido", Seniority.JUNIOR,project_1);
        Employee employee_2=new Employee("Empleado2","Empleado2Apellido", Seniority.ARCHITECT,project_1);
        Employee employee_3=new Employee("Empleado3","Empleado3Apellido", Seniority.SENIOR,project_1);

        employeeRepository.save(employee_1);
        employeeRepository.save(employee_2);
        employeeRepository.save(employee_3);


       // List<Project> projects = projectRepository.findAllByStartDateBetween(fechaInicio,fechaFin);

        List<Project> projects=projectRepository.findProjectBetweenQuerySQL(fechaInicio,fechaFin);

        List<Project> projectsHQL=projectRepository.findProjectBetweenQueryHQL(fechaInicio,fechaFin);

        List<Project> hqlEmpleado= employeeRepository.findProjectByEmployeeNameQueryHQL("Empleado1");

       // Project sqlEmpleado= (Project) employeeRepository.findProjectByEmployeeNameQuerySQL("Empleado1");
*/

        return  null;
    }
}
