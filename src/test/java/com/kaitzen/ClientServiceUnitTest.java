import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import com.kaitzen.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceUnitTest {
    @InjectMocks
    ClientService service;

    @Mock
    ClientRepository repository;

    @Test
    public void saveNewClientTest() {
        //given
        Long id = 1L;
        String name="raul";
        Client clientSaved=new Client();
        clientSaved.setId(id);
        clientSaved.setName(name);

        //when
        Client clientResult=service.save(null,name);

        //then
        assertEquals(id,clientResult.getId());
        assertEquals(name,clientResult.getName());
        verify(repository,times(1)).save(any(Client.class));
        verify(repository,times(0)).findById(any(Long.class));
    }
}
