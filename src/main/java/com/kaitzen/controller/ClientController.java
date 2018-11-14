package com.kaitzen.controller;

import com.kaitzen.model.Client;
import com.kaitzen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller //Va a maneja URLs
@RequestMapping("/client") //Siempre /api/client
public class ClientController {

    @Autowired
    ClientService clientService;
    @GetMapping
    public String index(Model model){//Esto lo maneja spring lo utilizamos y se mapea
        List<Client> clients= clientService.findAll();
        model.addAttribute("clients",clients);
        return "/client/index";//Nombre de archivo desde la carpeta template
    }

    @PostMapping("/new")
    public String create(Model model,@RequestParam(value = "clientName"/*,required = true para pedirlo obligatorio*/) String name){
        clientService.create(name);
        setClients(model);
        return "redirect:/client";
    }
    @PostMapping("/edit")
    public String edit(Model model,@RequestParam(value = "clientId") Long id, @RequestParam(value = "clientName"/*,required = true para pedirlo obligatorio*/) String name){
        clientService.save(id,name);
        setClients(model);
        return "redirect:/client";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam (value ="clientId") Long id){
        clientService.delete(id);
        return "redirect:/client";
    }

    private void setClients(Model model){
        model.addAttribute("clients",clientService.findAll());
    }
}
