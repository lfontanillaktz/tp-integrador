package com.kaitzen.controller;

import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {


    @Autowired
    ClientService clientService;

    @GetMapping
    public String index(Model model){
        setClients(model);
        return "/client/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam(value = "clientName") String name){
        clientService.save(null,name);
        return "redirect:/client";
    }

    @PostMapping("/edit")
    public String edit(Model model, @RequestParam(value = "clientId") Long id, @RequestParam(value = "clientName") String name){
        clientService.save(id, name);
        return "redirect:/client";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam("clientId") Long id){
        clientService.delete(id);
        return "redirect:/client";
    }

    private void setClients(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);//"clients" coincide con como lo llama en el index.html (linea 63)
    }

}
