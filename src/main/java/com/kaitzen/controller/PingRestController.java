package com.kaitzen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingRestController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/ping/{id}")
    public String pingId(@PathVariable("id") int id){
        return "ping id: "+id;
    }

}
