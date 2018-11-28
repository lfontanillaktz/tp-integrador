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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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

    //Permite manipular la base de datos directamente.
    @Autowired
    ClientService clientService;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void saveNewClientTest(){
        //Crear un cliente y asegurarse de que se guarde en la base

        //Given
        String mockedName = "Sancor";
        List<Client> clientsBeforeSave = clientRepository.findAll();

        //When
        Client clientSaved = clientService.save(null,mockedName);
        List<Client> clientsAfterSave = clientRepository.findAll();

        //Then
        assertEquals(clientsBeforeSave.size() + 1, clientsAfterSave.size());
        assertNotNull(clientSaved);
        assertNotNull(clientSaved.getId());
        assertEquals(mockedName, clientSaved.getName());
    }

    @Test
    public void findAllTest(){
        //Given
        //Creacion de objetos
        Client client1 = new Client("Sancor");
        Client client2 = new Client("MercadoLibre");
        //Guardado de objetos (conexion directa a la base)
        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.flush(); //Para que se termine la transaccion y se guarde
        //When
        List<Client> clients = clientService.findAll();
        //Then
        //Para ver que la lista tenga tamanio de 2 que es lo que hay en la base
        assertNotNull(clients);
        assertEquals(2,clients.size());
        //Para verificar que los que trajo son los correctos
        assertEquals(client1.getId(), clients.get(0).getId());
        assertEquals(client1.getName(), clients.get(0).getName());

        assertEquals(client2.getId(), clients.get(1).getId());
        assertEquals(client2.getName(), clients.get(1).getName());

    }
}
