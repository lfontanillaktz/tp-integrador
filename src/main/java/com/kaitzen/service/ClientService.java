package com.kaitzen.service;

import com.kaitzen.model.Client;
import com.kaitzen.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {

    @Autowired //Inyectar dependencias
    ClientRepository clientRepository;

    //@Transactional //Sirve para mantener el ACID si algo falla no hagas nada
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public void create(String name){
        Client client= new Client();
        client.setName(name);
        clientRepository.save(client);
    }
    public void save(Long id, String name){
        Client client=null;
        if(id==null){
            client=new Client();
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
