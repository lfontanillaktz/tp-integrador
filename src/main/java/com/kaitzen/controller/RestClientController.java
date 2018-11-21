package com.kaitzen.controller;


import com.kaitzen.Modelos.Client;
import com.kaitzen.Service.ClientService;
import com.kaitzen.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/client")
public class RestClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> findAll(){
        List<Client> clientList = clientService.findAll();
        return clientList; //la lista se muestra directamente por pantalla en formato Json (transformacion automatica)
    }

    @GetMapping("/{id:[\\d]+}") //agregamos la expresion regular: solo numero/s
    public  Client findById(@PathVariable(value = "id") Long id){
        Client client = clientService.findById(id);
        if(client == null){
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        return client;
    }

    //el retorno Client en los metodos puede estar o no (void andaria tambien)

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) //toda peticion http retorna un estado, para creacion debe ser 201 (CREATED)
    public Client create(@RequestBody ClientDTO clientDTO){
        try {
            return clientService.save(null, clientDTO.getName());
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Falló la creación del nuevo usuario");
        }
    }

    @PutMapping("/{id:[\\d]+}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Client edit(@RequestBody ClientDTO clientDTO, @PathVariable (value = "id") Long id){
        try{
            return clientService.save(id, clientDTO.getName());
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Falló la modificación del usuario");
        }
    }

    @DeleteMapping("/{id:[\\d]+}")
    public void delete(@PathVariable (value = "id") Long id){
        try{
            clientService.delete(id);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Falló la eliminación del usuario");
        }
    }
}
