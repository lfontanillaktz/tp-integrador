package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientServiceIntegrationTest {
    @TestConfiguration
    static class ClientServiceIntegrationTestContextConfiguration{
        @Bean
        public ClientService clientService(){
            return new ClientService();
        }
    }
    @Autowired
    ClientService clientService;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void saveNewClientTest(){
        //Given
        String mockedName="Saul";
        List<Client> clientsBeforeSaving = clientRepository.findAll();


        //When
        Client clientSaved = clientService.save(null,mockedName);

        List<Client> clientsAfterSaving = clientRepository.findAll();
        //Then
        assertEquals(clientsBeforeSaving.size()+1,clientsAfterSaving.size());
        assertNotNull(clientSaved);
        assertNotNull(clientSaved.getId());
        assertEquals(mockedName,clientSaved.getName());
    }
    @Test
    public void findAllTest(){
        //Given
        Client client1 = new Client("Ricardito");
        Client client2 = new Client("SancorBB3");
        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.flush();
        //When
        List<Client> clients = clientService.findAll();
        //Then
        assertNotNull(clients);
        assertEquals(2,clients.size());
        assertEquals(client1.getId(),clients.get(0).getId());
        assertEquals(client2.getId(),clients.get(1).getId());
        assertEquals(client1.getName(),clients.get(0).getName());
        assertEquals(client2.getName(),clients.get(1).getName());
    }

    @Test
    public void saveEditClientTest(){
        //given
        String name = "Adolf";
        Client client = new Client("Adolfo");
        entityManager.persist(client);
        entityManager.flush();
        //when
        Client clientSaved = clientService.save(client.getId(),name);
        //then
        assertEquals(name,clientSaved.getName());
    }

}
