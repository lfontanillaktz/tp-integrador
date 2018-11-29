package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientServiceIntegrationTest {

    @TestConfiguration
    static class ClientServiceIntegrationTestContextConfiguration {

        @Bean
        public ClientService clientService() {
            return new ClientService();
        }
    }

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Test
    public void findByNameTest() {
        // Given
        Client client = new Client("Sancor");

        entityManager.persist(client);
        entityManager.flush();

        // when
        Client clientFound = clientService.findClientByNameQueryHQL(client.getName());

        // then
        Assert.assertEquals(client.getId(), clientFound.getId());
        Assert.assertEquals(client.getName(), clientFound.getName());
    }

    @Test
    public void findAllTest() {
        // given
        Client client1 = new Client("Sancor");
        Client client2 = new Client("MercadoLibre");

        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.flush();

        // when
        List<Client> clients = clientService.findAll();

        // then
        Assert.assertEquals(2, clients.size());

        Assert.assertEquals(client1.getId(), clients.get(0).getId());
        Assert.assertEquals(client1.getName(), clients.get(0).getName());

        Assert.assertEquals(client2.getId(), clients.get(1).getId());
        Assert.assertEquals(client2.getName(), clients.get(1).getName());
    }

    @Test
    public void createNewClientTest() {
        // given
        String mockedName = "Sancor";
        List<Client> clientsBeforeCreate = clientRepository.findAll();
        Client clientFoundBeforeCreate = clientRepository.findClientByNameQueryHQL(mockedName);

        // When
        Client clientSaved = clientService.save(null, mockedName);
        List<Client> clientsAfterCreate = clientRepository.findAll();

        Client clientFoundAfterCreate = clientRepository.findClientByNameQueryHQL(mockedName);

        // Then
        Assert.assertEquals(clientsBeforeCreate.size() + 1, clientsAfterCreate.size());
        Assert.assertNotNull(clientSaved.getId());
        Assert.assertEquals(mockedName, clientSaved.getName());

        Assert.assertNull(clientFoundBeforeCreate);
        Assert.assertNotNull(clientFoundAfterCreate);
    }

    @Test
    public void updateClientTest() {
        // given
        String mockedName = "Sancor";
        String mockedNewName = "MercadoLibre";

        entityManager.persist(new Client(mockedName));
        entityManager.flush();

        Client clientFoundBeforeUpdate = clientRepository.findClientByNameQueryHQL(mockedName);

        // When
        Client clientSaved = clientService.save(clientFoundBeforeUpdate.getId(), mockedNewName);

        Client clientOldName = clientRepository.findClientByNameQueryHQL(mockedName);
        Client clientFoundAfterUpdate = clientRepository.findClientByNameQueryHQL(mockedNewName);

        // Then
        Assert.assertNull(clientOldName);
        Assert.assertNotNull(clientFoundAfterUpdate);

        Assert.assertEquals(clientSaved.getName(), mockedNewName);
        Assert.assertEquals(clientFoundBeforeUpdate.getId(), clientFoundAfterUpdate.getId());


    }

    @Test
    public void deleteCLientTest() {
        // given
        String mockedName = "Sancor";
        Client client1 = new Client(mockedName);
        Client client2 = new Client("MercadoLibre");

        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.flush();

        List<Client> clientsBeforeDelete = clientRepository.findAll();
        Client clientToDelete = clientRepository.findClientByNameQueryHQL(mockedName);

        // when
        clientService.delete(clientToDelete.getId());

        Client clientDeleted = clientRepository.findClientByNameQueryHQL(mockedName);
        List<Client> clientsAfterDelete = clientRepository.findAll();

        // then
        Assert.assertEquals(clientsBeforeDelete.size() - 1, clientsAfterDelete.size());
        Assert.assertNull(clientDeleted);
    }

}