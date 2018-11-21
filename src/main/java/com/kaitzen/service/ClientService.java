package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(Long id){
     Optional<Client> client = clientRepository.findById(id);
     if(client.isPresent()){
         return client.get();
        }
        else return null;
    }
    public Client save(Long id, String name){
        Client client = null;
        if(id==null){
            client = new Client();
        }
        else{
            client=clientRepository.findById(id).get();
        }
        client.setName(name);
        clientRepository.save(client);
        return client;
    }
    public void delete(Long id){
        clientRepository.deleteById(id);
    }
}
