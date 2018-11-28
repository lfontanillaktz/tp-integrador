package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceUnitTest {

    @InjectMocks
    ClientService service;

    @Mock
    ClientRepository repository;

    //@BeforeEach se ejecuta antes de cada test, por ejemplo para limpiar registros.

    @Test
    public void saveClientTest(){
        //Given
        //Crear un cliente para guardar
        Long id = 1L;
        String name = "raul";
        Client clientSaved = new Client();
        clientSaved.setId(id);
        clientSaved.setName(name);
        //Si se recibe cualquier cliente, retornar el clientSaved
        when(repository.save(any(Client.class))).thenReturn(clientSaved);

        //When
        Client clientResult = service.save(null, name);

        //Then
        //Datos correctos
        assertEquals(id, clientResult.getId());
        assertEquals(name, clientResult.getName());
        //Flujo correcto
        verify(repository, times(1)).save(any(Client.class));
        verify(repository, times(0)).findById(any(Long.class));

    }

}
