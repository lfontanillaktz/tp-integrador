package com.kaitzen.controller;

import com.kaitzen.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String getClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "/client/index";
    }

    @PostMapping("/new")
    public String save(Model model, @RequestParam(value = "clientName") String clientName) {
        try {
            clientService.save(null, clientName);
            model.addAttribute("successMessage", "Se creo el cliente");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "No se pudo crear el cliente");
        }
        model.addAttribute("clients", clientService.findAll());
        return "/client/index";
    }

    @PostMapping("/edit")
    public String update(Model model, @RequestParam(value = "clientId") Long clientId, @RequestParam(value = "clientName") String clientName) {
        try {
            clientService.save(clientId, clientName);
            model.addAttribute("successMessage", "Se edito el cliente");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "No se pudo editar el cliente");
        }
        model.addAttribute("clients", clientService.findAll());
        return "/client/index";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam(value = "clientId") Long clientId) {
        try {
            clientService.delete(clientId);
            model.addAttribute("successMessage", "Se elimino el cliente");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "No se pudo eliminar el cliente");
        }
        model.addAttribute("clients", clientService.findAll());
        return "/client/index";
    }
}
