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
public class ClientServiceInteractionTest {

    @TestConfiguration
    static class ClientServiceIntegrationTestContextConfiguration {

        @Bean
        public ClientService clientService() {
            return new ClientService();
        }

    }

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void saveNewClientTest() {

        //Given:
        String mockedName = "Sancor";

        List<Client> clientsBeforeSave = clientRepository.findAll();

        //When:
        Client clientSaved = clientService.save(null, mockedName);

        List<Client> clientsAfterSave = clientRepository.findAll();

        //Then:
        assertEquals(clientsBeforeSave.size() + 1, clientsAfterSave.size());
        assertNotNull(clientSaved);
        assertNotNull(clientSaved.getId());
        assertEquals(mockedName, clientSaved.getName());

    }

    @Test
    public void findAllTest() {

        //Given
        Client client1 = new Client("Sancor");
        Client client2 = new Client("Mercadolibre");

        entityManager.persist(client1);
        entityManager.persist(client2);

        //When
        List<Client> clients = clientService.findAll();

        //Then:
        assertNotNull(clients);
        assertEquals(clients.get(0).getName(), "Sancor");
        assertEquals(clients.get(1).getName(), "Mercadolibre");


    }


}
