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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
    ClientRepository clientRepository;

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ClientService clientService;

    @Test
    public void saveNewClientTest(){
        //Given:
        String mockedName = "xD";
        List<Client> clientsBeforeSave = clientRepository.findAll();

        //When:
        Client clientSaved = clientService.save(null,mockedName);
        List<Client> clientsAfterSave = clientRepository.findAll();

        //Then:

        assertEquals(clientsBeforeSave.size()+1, clientsAfterSave.size());
        assertNotNull(clientSaved);
        assertNotNull(clientSaved.getId());
        assertEquals(mockedName, clientSaved.getName());
    }

    @Test
    public void findAllTest(){
        //Given
        Client client1 = new Client("xD");
        Client client2 = new Client("xD2");
        Client client3 = new Client("xD3");
        Client client4 = new Client("xD4");

        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.persist(client3);
        entityManager.persist(client4);
        entityManager.flush();


        //When
        List<Client> clients = clientService.findAll();
        //Then
        assertNotNull(clients);
        assertEquals(4, clients.size());

        assertEquals(client1.getId(),clients.get(0).getId());
        assertEquals(client2.getId(),clients.get(1).getId());
        assertEquals(client3.getId(),clients.get(2).getId());
        assertEquals(client4.getId(),clients.get(3).getId());

        assertEquals(client1.getName(),clients.get(0).getName());
        assertEquals(client2.getName(),clients.get(1).getName());
        assertEquals(client3.getName(),clients.get(2).getName());
        assertEquals(client4.getName(),clients.get(3).getName());


    }

    @Test
    public void saveEditClientTest(){
        //Given
        Client mockedClient = new Client("xD");
        //When
        Client clientSaved = clientService.save(mockedClient.getId(),":D");
        //Then
        assertEquals(":D", clientSaved.getName());
        assertNotNull(clientRepository.findClientByNameQueryHQL(":D"));
        
    }


}
