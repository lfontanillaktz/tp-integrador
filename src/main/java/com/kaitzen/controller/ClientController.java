package com.kaitzen.controller;

import com.kaitzen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String index(Model model){
        //List<Client> clients = clientService.findAll();
        //model.addAttribute("clients",clients);
        setClients(model);
        return "/client/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam(value = "clientName") String name){
        try{
            clientService.save(null, name);
            model.addAttribute("successMessage","Se creo el cliente exitosamente");
        }catch (Exception e){
            model.addAttribute("errorMessage", "No se pudo crear el cliente");
        }
        return "redirect:/client";

    }

    @PostMapping("/edit")
    public String edit(@RequestParam(value = "clientId") Long id, @RequestParam(value = "clientName") String name){
            clientService.save(id,name);

            return "redirect:/client";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "clientId") Long id){
        clientService.delete(id);
        return "redirect:/client";

    }

    @PostMapping("/client/n")
    public String exitoso(Model model){

        return("/client/index");
    }

    private void setClients(Model model){
        model.addAttribute("clients", clientService.findAll());
    }



}
