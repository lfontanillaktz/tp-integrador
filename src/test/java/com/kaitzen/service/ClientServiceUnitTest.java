package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class) //Con el soporte del runner MockitoJUnitRunner y la anotación @Mock, mockito se encarga de crear un mock para los objetos anotados.
@SpringBootTest
public class ClientServiceUnitTest {

    @InjectMocks //En su clase de prueba, la clase probada debe ser anotada con @InjectMocks. Esto le dice a Mockito a qué clase inyectar se burla:
    ClientService service;

    @Mock //podemos especificar qué métodos u objetos específicos dentro de la clase, en este caso repository , serán sustituidos por mocks:
    ClientRepository repository;

    @Test
    public void findByIdTest() {
        // given
        Long id = 1L;
        String name = "pablo";
        Client client = new Client();
        client.setId(id);
        client.setName(name);

        Optional<Client> opClient = Optional.of(client);

        when(repository.findById(id)).thenReturn(opClient);

        // when
        Client clientResult = service.findById(id);

        // then
        assertEquals(id, clientResult.getId());
        assertEquals(name, clientResult.getName());
    }

    @Test
    public void findByIdTestMock() {
        // given
        Long id = 1L;
        String name = "pablo";
        Client client = mock(Client.class);
        when(client.getId()).thenReturn(id);
        when(client.getName()).thenReturn(name);

        Optional<Client> opClient = Optional.of(client);

        when(repository.findById(id)).thenReturn(opClient);

        // when
        Client clientResult = service.findById(id);

        // then
        assertEquals(id, clientResult.getId());
        assertEquals(name, clientResult.getName());
    }

    @Test
    public void findAllTest() {
        // given
        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("pablo");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("lucas");

        List<Client> clientList = new ArrayList();
        clientList.add(client1);
        clientList.add(client2);

        when(repository.findAll()).thenReturn(clientList);

        // when
        List<Client> clientResults = service.findAll();

        // then
        assertEquals(client1, clientResults.get(0));
        assertEquals(client2, clientResults.get(1));
    }

    @Test
    public void findAllTestMock() {
        // given
        Client client1 = mock(Client.class);
        Client client2 = mock(Client.class);

        List<Client> clientList = new ArrayList();
        clientList.add(client1);
        clientList.add(client2);

        when(repository.findAll()).thenReturn(clientList);

        // when
        List<Client> clientResults = service.findAll();

        // then
        assertEquals(client1, clientResults.get(0));
        assertEquals(client2, clientResults.get(1));
    }

    @Test
    public void saveNewClientTest() {
        // given
        Long id = 1L;
        String name = "pol";
        Client clientSaved = new Client();
        clientSaved.setId(id);
        clientSaved.setName(name);

        when(repository.save(any(Client.class))).thenReturn(clientSaved);

        // when
        Client clientResult = service.save(null, name);

        // then
        verify(repository, times(1)).save(any(Client.class));
        verify(repository, times(0)).findById(id);
        assertEquals(id, clientResult.getId());
        assertEquals(name, clientResult.getName());
    }

    @Test
    public void saveNewClientTestMock() {
        // given
        Long id = 1L;
        String name = "pol";
        Client clientSaved = mock(Client.class);
        when(clientSaved.getId()).thenReturn(id);
        when(clientSaved.getName()).thenReturn(name);

        when(repository.save(any(Client.class))).thenReturn(clientSaved);

        // when
        Client clientResult = service.save(null, name);

        // then
        verify(repository, times(1)).save(any(Client.class));
        verify(repository, times(0)).findById(id);
        assertEquals(id, clientResult.getId());
        assertEquals(name, clientResult.getName());
    }

    @Test
    public void updateExistentClientTest() {
        // given
        Long id = 1L;
        String name = "lucas";
        String newName = "luquitas";
        Client clientFound = new Client();
        clientFound.setId(id);
        clientFound.setName(name);

        Client clientSaved = new Client();
        clientSaved.setId(id);
        clientSaved.setName(newName);

        Optional<Client> opClient = Optional.of(clientFound);

        when(repository.findById(id)).thenReturn(opClient);
        when(repository.save(any(Client.class))).thenReturn(clientSaved);

        // when
        Client clientResult = service.save(id, newName);

        // then
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(any(Client.class));
        assertEquals(id, clientResult.getId());
        assertEquals(newName, clientResult.getName());
    }

    @Test
    public void updateExistentClientTestMock() {
        // given
        Long id = 1L;
        String newName = "luquitas";
        Client clientFound = mock(Client.class);

        Client clientSaved = mock(Client.class);
        when(clientSaved.getId()).thenReturn(id);
        when(clientSaved.getName()).thenReturn(newName);

        Optional<Client> opClient = Optional.of(clientFound);

        when(repository.findById(id)).thenReturn(opClient);
        when(repository.save(any(Client.class))).thenReturn(clientSaved);

        // when
        Client clientResult = service.save(id, newName);

        // then
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(any(Client.class));
        assertEquals(id, clientResult.getId());
        assertEquals(newName, clientResult.getName());
    }

}
