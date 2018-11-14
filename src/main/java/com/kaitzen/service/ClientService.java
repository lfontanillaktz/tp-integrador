package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public void save(Long id, String name){
        Client client;
        if(id==null){//cliente nuevo
            client = new Client();
        }else{
            client = clientRepository.findById(id).get();
        }
        client.setName(name);
    clientRepository.save(client);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

}
