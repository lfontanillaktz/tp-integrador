package com.kaitzen.controller;

import com.kaitzen.dto.ClientDTO;
import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/client")
public class RestClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> findAll(){
        List<Client> clients= clientService.findAll();
        return clients;
    }

    @GetMapping("/{id:[\\d]+}")
    public Client findById(@PathVariable(value="id") Long id){
        Client client = clientService.findById(id);

        if(client==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client not found");
        return client;
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client create(@RequestBody ClientDTO clientDTO) {
        try{
            Client client= clientService.create(clientDTO.getName());
            return client;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error en la creación del cliente");
        }

    }
}
