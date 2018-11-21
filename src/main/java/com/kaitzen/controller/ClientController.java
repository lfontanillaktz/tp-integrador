package com.kaitzen.controller;

import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
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
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "/client/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam(value = "clientName") String name){

        clientService.save(null, name);
        model.addAttribute("clients", clientService.findAll());
        return "redirect:/client";
    }

    @PostMapping("/edit")
    public String edit(Model model, @RequestParam(value = "clientId") Long id, @RequestParam(value = "clientName") String name){
        clientService.save(id,name);
        model.addAttribute("clients",clientService.findAll());
        return "redirect:/client";
    }
    @PostMapping("/delete")
    public String delete(Model model, @RequestParam(value= "clientId") Long id){
        clientService.delete(id);
        model.addAttribute("clients",clientService.findAll());
        return "redirect:/client";
    }


}
