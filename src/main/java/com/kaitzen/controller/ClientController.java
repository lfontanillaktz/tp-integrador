package com.kaitzen.controller;

import com.kaitzen.Modelos.Client;
import com.kaitzen.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String index(Model model){
        //busca todos los clientes desde la BD
        List<Client> clientes = clientService.findAll();
        //pone la lista de usuarios traida de la BD en pantalla
        model.addAttribute("clients", clientes); //el "clients" hace referencia a la lista definida en el index
    return "/client/index"; //posiciona dentro de la carpeta templates el archivo index.html
    }

    @PostMapping("/new") //el new esta tambien en index(144)
    public String create(@RequestParam(value = "clientName") String name){ //clientName esta en index(156)
        clientService.save(null, name);
        //volvemos a la pantalla /client
        return "redirect:/client";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value = "clientId") Long id, @RequestParam(value = "clientName") String name){
        clientService.save(id, name);
        return "redirect:/client";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "clientId") Long id){
        clientService.delete(id);
        return "redirect:/client";
    }

}
