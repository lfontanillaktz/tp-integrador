package com.kaitzen;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.kaitzen"})
@EnableJpaAuditing
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

@Bean
    ApplicationRunner  run(ClientRepository clientRepository){
        Client client_1= new Client("RAULito");
        clientRepository.save(client_1);
    Client nuevo = new Client();
        nuevo=clientRepository.findClientByNmaeQueryHQL("RAULito");

    System.err.printf("lo que obtuve es lo siguiente  "+nuevo.getName());

return null;
}

}
