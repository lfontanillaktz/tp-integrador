package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client save(Long id, String name){
        Client client;
        if(id==null){//cliente nuevo
            client = new Client();
        }else{
            client = clientRepository.findById(id).get();
        }
        client.setName(name);
        client = clientRepository.save(client);
        return client;
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    public Client findById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        return client.isPresent() ? client.get() : null;
    }

    public Client create(String name){
        Client client = new Client(name);
        clientRepository.save(client);
        return client;
    }
}
