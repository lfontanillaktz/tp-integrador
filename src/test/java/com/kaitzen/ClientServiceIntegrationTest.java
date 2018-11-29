package com.kaitzen;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.service.ClientService;
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

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientServiceIntegrationTest {

    @TestConfiguration
    static class ClientServiceIntegrationTestConfiguration {

        @Bean
        public ClientService clientService(){
            return new ClientService();
        }

    }

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void saveNewClientTest(){
        //Given
        String mockedName = "Sancor";
        List<Client> clientsBeforeSave = clientService.findAll();

        //When
        Client clientSaved = clientService.save(null, mockedName);
        List<Client> clientsAfterSave = clientService.findAll();

        //Then
        assertEquals(clientsBeforeSave.size()+1, clientsAfterSave.size());
    }

    @Test
    public void findAllTest(){
        //Given
        Client client1 = new Client("Sancor"), client2 = new Client("MercadoLibre");

        testEntityManager.persist(client1);
        testEntityManager.persist(client2);

        //When
        List<Client> clients = clientService.findAll();

        //Then
        assertNotNull(clients);
        assertEquals(2, clients.size());

        assertEquals(client1.getId(), clients.get(0).getId());
        assertEquals(client1.getName(), clients.get(0).getName());
    }

}
