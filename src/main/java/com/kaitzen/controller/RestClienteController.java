package com.kaitzen.controller;

import com.kaitzen.DTO.ClientDTO;
import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/client")
public class RestClienteController {
    @Autowired
    ClientService clienteService;

    @GetMapping
    public List<Client> findAll() {
       List<Client> clients= clienteService.findAll();
        return clients;
    }

    @GetMapping("/{id:[\\d+]}")
    public Client findById (@PathVariable(value ="id") Long id){
        Client client =clienteService.findById(id);
        if(client ==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client no found");
        return client;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client create(@RequestBody ClientDTO clientDTO){
        try {
            Client client = clienteService.create(clientDTO.getName());
            return client;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Creation failed");
        }
    }

    @PutMapping ("/{id:[\\d+]}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Client edit (@RequestBody ClientDTO clientDTO,@PathVariable(value ="id") Long id){
        try {
            Client client = clienteService.save(id, clientDTO.getName());
            return client;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Edition failed");
        }
    }

    @DeleteMapping("/{id:[\\d+]}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete (@PathVariable(value ="id") Long id){
        try {
            clienteService.delete(id);
            return;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Delete failed");
        }
    }

}
