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

    public Client create(String name) {
        return this.save(null, name);
    }

    public Client save(Long id, String name) {
        Client client = null;
        if (id == null) {
            client = new Client();
        } else {
            client = clientRepository.findById(id).get();
        }
        client.setName(name);
        clientRepository.save(client);
        return client;
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
        Optional<Client> client = clientRepository.findById(id);
        return client.isPresent() ? client.get() : null;
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
