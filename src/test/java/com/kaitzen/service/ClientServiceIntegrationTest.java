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
    static class ClientServiceIntegrationTestContextConfiguration{
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
    TestEntityManager entityManager;
    @Test
    public void saveNewClientTest(){
        //given
        String mockedName ="Sancorr";
        List<Client> clientsDefaultSaved= clientRepository.findAll();
        //when
        Client clientSaved = clientService.save(null, mockedName);
        List<Client> clientsAftersSaved= clientRepository.findAll();
        //then
        Assert.assertEquals(clientsDefaultSaved.size() +1, clientsAftersSaved.size());
        Assert.assertNotNull(clientSaved);
        Assert.assertNotNull(clientSaved.getId());
        Assert.assertEquals(mockedName,clientSaved.getName());

    }

    @Test
    public void findAllTest(){
        //given
        Client client1= new Client("sancor");
        Client client2= new Client("nestle");
        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.flush();

        //when
        List<Client> clientes= clientService.findAll();

        //then
        Assert.assertNotNull(clientes);
        Assert.assertEquals(2,clientes.size());

        Assert.assertEquals(clientes.get(0).getId(),client1.getId());
        Assert.assertEquals(clientes.get(0).getName(),client1.getName());

        Assert.assertEquals(clientes.get(1).getId(),client2.getId());
        Assert.assertEquals(clientes.get(1).getName(),client2.getName());
    }

}
