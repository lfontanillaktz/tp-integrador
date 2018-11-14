package com.kaitzen;

import com.kaitzen.controller.PingRestController;
import com.kaitzen.model.Client;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /*@Bean //Creacion a de nuevas cosas
    ApplicationRunner run(ProjectRepository projectRepository) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);


        Project project1 = new Project();
        project1.setName("sancor");
        Date date1 = formatter.parse("10-12-2018");
        project1.setStartDate(date1);
        projectRepository.save(project1);

        Project project2 = new Project();
        project2.setName("meli");
        Date date2 = formatter.parse("12-12-2018");
        project2.setStartDate(date2);
        projectRepository.save(project2);

        Project project3 = new Project();
        project3.setName("musimundo");
        Date date3 = formatter.parse("23-12-2018");
        project3.setStartDate(date3);
        projectRepository.save(project3);

        *//*Date dateFrom = formatter.parse("09-12-2018");
        Date dateTo = formatter.parse("20-12-2018");
        //List<Project> projects = repository.findProjectsByStartDateIsBetween(dateFrom, dateTo);
        //List<Project> projects = repository.findProjectsByStartDateIsBetweenQueryHQL(dateFrom, dateTo);
        List<Project> projects = projectRepository.findProjectsByStartDateIsBetweenQuerySQL(dateFrom, dateTo);
        for (Project project : projects) {
            System.out.println(project.toString());
        }*//* //Ver comparacion de fechas



        *//*TODO para el client, al hacerlo por id, lo hacemos desde acá *//*
        Client c = new Client();
        c.setName("PoL");
        clientRepository.save(c);

        //Client client = clientRepository.findById(1L).get();
        //Client client = clientRepository.findByIdQueryHQL(1L);
        Client client = clientRepository.findByIdQuerySQL(1L);
        System.out.println(client.toString());


*//*        return args ->
                Stream.of("Lucas", "Juan", "Pablo", "Jose").forEach(
                        name -> customerRepository.save(new Customer(name)));*//*


        return null;
    }*/



}
