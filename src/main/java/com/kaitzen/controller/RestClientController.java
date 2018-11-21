package com.kaitzen.controller;

import com.kaitzen.dto.ClientDTO;
import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
import org.aspectj.apache.bcel.ExceptionConstants;
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
       List<Client> clients = clientService.findAll();
       return clients;
   }

   //Encontrar un cliente por su ID, \\d para que sea numero
   @GetMapping("/{id:[\\d]+}")
    public Client findById(@PathVariable("id") Long id){
       //Usando el metodo de ClientService para encontrar por ID
    Client client=clientService.findById(id);
    //Para errores, en caso de que no exista el cliente con esa ID
       if(client == null)
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");

    return client;
   }

    //Creacion del objeto
    @PostMapping
    //Para que devuelva el codigo correcto, en vez de 200, 201.
    @ResponseStatus(code = HttpStatus.CREATED)
    public Client create(@RequestBody ClientDTO clientDTO) {
       //Si falla el guardado, para no meter errores
        try{
            Client client = clientService.create(clientDTO.getName());
            return client;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Creation failed");
        }
    }

    //Para editar un objeto
  @PutMapping ("/{id:[\\d]+}")
  @ResponseStatus(code=HttpStatus.ACCEPTED)
  public Client edit(@RequestBody ClientDTO clientDTO, @PathVariable(value="id") Long id){
      try {
          Client client = clientService.save(id, clientDTO.getName());
          return client;
      }catch(Exception e){
          throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Edition failed");
      }
    }

    //Eliminar un objeto
    @DeleteMapping ("/{id:[\\d]+}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public void delete (@PathVariable(value="id") Long id){
       try {
           clientService.delete(id);
       }catch (Exception e){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Delete failed");
       }
    }



}
