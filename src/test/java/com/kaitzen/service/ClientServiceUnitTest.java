package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceUnitTest {
    @InjectMocks
    ClientService service;
    @Mock
    ClientRepository repository;
    @Test
    public void saveClientTest(){
        //given
        long id = 11;
        String name = "raul";


        Client clientSaved=new Client();
        clientSaved.setId(id);
        clientSaved.setName(name);


        when(repository.save(any(Client.class))).thenReturn(clientSaved);
        //when
        Client clientResult =service.save (null, name);
        //then
            //datos correctos
            Assert.assertEquals(id,clientResult.getId());
            Assert.assertEquals(name, clientResult.getName());
            //flujo correcto
            verify(repository, times(1)).save(any(Client.class));
            verify(repository, times(0)).findById(any(long.class));


    }

}
