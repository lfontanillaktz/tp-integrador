package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import com.sun.xml.internal.ws.api.pipe.ClientPipeAssemblerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client create(String name){
        return this.save(null,name);
    }

    public Client save(Long id, String name){
        Client client = null;
        if(id==null){
            client = new Client();
        } else {
            client= clientRepository.findById(id).get();
        }
        client.setName(name);
        clientRepository.save(client);
        return client;
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public Client findById(long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.isPresent()?client.get():null;
    }
}
