package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client save(Long id, String name) {
        Client client = null;
        if(id == null){
            client = new Client();
        } else {
            client = this.findById(id);
        }
        client.setName(name);

        return clientRepository.save(client);
    }

    /*
    TODO ejemplo de método save con transaccionalidad donde no se guarda ningún valor.
    @Override
    @Transactional
    public Client save(Client client) {
        repository.save(client);
        Integer.parseInt("");
        Client client2 = new Client("Sancor");
        clientRepository.save(client2);
        return null;
    }
    */

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }

    public List<Client> byName(String name) {
        return clientRepository.findAllByNameIgnoreCase(name);
    }

    public Client findClientByNameQueryHQL(String name) {
        return clientRepository.findClientByNameQueryHQL(name);
    }

    public Client findClientByNameQuerySQL(String name) {
        return clientRepository.findClientByNameQuerySQL(name);
    }

}
