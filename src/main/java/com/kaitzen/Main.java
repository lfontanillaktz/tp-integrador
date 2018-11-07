package com.kaitzen;

import com.kaitzen.model.Client;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.ProjectRepository;
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

    @Bean
    ApplicationRunner run1 (ClientRepository clientRepository){

        Client client_1 = new Client("raul");
        clientRepository.save(client_1);

        Client client_2 = new Client("pedro");
        clientRepository.save(client_2);

        Client client_3 = new Client("everman");
        clientRepository.save(client_3);

        Client client_4 = new Client("malena");
        clientRepository.save(client_4);



       // List<Client> respuesta = clientRepository.findAllByName("raul");
        Client respuesta = clientRepository.findClientByNameQueryHQL("raul");
        System.out.println(respuesta.toString());
        return null;
    }

    @Bean
    ApplicationRunner run2 (ProjectRepository projectRepository) throws ParseException {

        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date date1 = f.parse("14-05-2000");
        Project proyecto1 = new Project("proyecto1",date1);
        projectRepository.save(proyecto1);

        Date date2 = f.parse("05-05-2000");
        Project proyecto2 = new Project("proyecto2",date2);
        projectRepository.save(proyecto2);

        Date date3 = f.parse("20-05-2000");
        Project proyecto3 = new Project("proyecto3",date3);
        projectRepository.save(proyecto3);

        List<Project> res = projectRepository.findByStartDateBetweenHQL(date2,date3);
        System.out.println(res.get(0).toString());

        return null;
    }

}
