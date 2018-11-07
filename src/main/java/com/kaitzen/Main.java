package com.kaitzen;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.repository.EmployeeRepository;
import com.kaitzen.repository.ProjectRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.*;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    ApplicationRunner run(ClientRepository clientRepository){
        Client client_1 = new Client("raul");
        clientRepository.save(client_1);

        /*List<Client> listaClientes = clientRepository.findAllByName("raul");
        System.out.println("****************************");
        System.out.println(listaClientes.get(0).getName());
        */

        Client clientConsultaHQL = clientRepository.findClientByNameHQL("raul");
        System.out.println("****************************");
        System.out.println(clientConsultaHQL.getName());

        Client clientConsultaSQL = clientRepository.findClientByNameSQL("raul");
        System.out.println("****************************");
        System.out.println(clientConsultaSQL.getName());

        return null;
    }


}
