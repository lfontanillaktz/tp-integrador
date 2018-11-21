package com.kaitzen.controller;

import com.kaitzen.dto.ClientDTO;
import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/rest/client")
public class RestClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> findAll(){
        List<Client> clients = clientService.findAll();
        return clients;
    }

    @GetMapping("/{id:[\\d]+}")
    public Client findById(@PathVariable(value = "id") Long id){
        Client client = clientService.findById(id);
        if (client == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return client;
    }

    @PostMapping
    @ResponseStatus (code = HttpStatus.CREATED)
    public Client create(@RequestBody ClientDTO clientDTO){
        try{
            Client client = clientService.create(clientDTO.getName());
            return client;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Creation fails");
        }

    }

    @PostMapping("/(id:[\\d]+)")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Client edit(@RequestBody ClientDTO clientDTO, @PathVariable(value = "id") Long id){
        try {
            Client client = clientService.save(null, clientDTO.getName());
            return client;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Edit fails");
        }
    }

    @DeleteMapping("/(id:[\\d]+)")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@RequestBody ClientDTO clientDTO, @PathVariable(value = "id") Long id) {
        try {
            clientService.delete(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Delete fails");
        }
    }
}