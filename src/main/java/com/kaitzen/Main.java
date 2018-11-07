package com.kaitzen;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Modelos.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.ProjectRepository;
import jdk.nashorn.internal.objects.NativeString;
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
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean //solo un Bean y un run
    ApplicationRunner run(ClientRepository clientRepository, ProjectRepository projectRepository) throws ParseException {
        //Client client = new Client();
        //client.setName("Raul");
        //clientRepository.save(client);

        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        /*
        Date date = f.parse("07-11-2018");
        Project project = new Project();
        project.setName("proyecto 1");
        project.setStartDate(date);
        projectRepository.save(project);
        */

        Date date = f.parse("11-07-2018");
        Project project = new Project();
        project.setName("proyecto 1");
        project.setStartDate(date);
        projectRepository.save(project);



        List<Client> clientRta = clientRepository.findAllByName("Raul");

        //consulta usando HQL
        Client client1 = clientRepository.finClientByNameQueryHQL("Raul");
        System.out.println(client1.getName());

        //consulta usando SQL
        Client client2 = clientRepository.findClientByNameQuerySQL("Raul");
        System.out.println(client2.getName());

        Date date1 = f.parse("05-11-2018");
        Date date2 = f.parse("09-11-2018");
        List<Project> projectList = projectRepository.findByStartDateBetween(date1,date2);
        System.out.println(projectList.get(0).getName());


        return null;
    }
}
