package com.kaitzen.Service;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return  clientRepository.findAll();
    }

    public Client save(Long id, String name){//el long es para update, no hace falta para crear
        Client client = null;

        //crear
        if(id==null){
            client = new Client();
        }
        //modificar
        else{
            client = clientRepository.findById(id).get();
        }

        client.setName(name);
        client = clientRepository.save(client);
        return client;
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.isPresent()? client.get() : null;
    }
}
