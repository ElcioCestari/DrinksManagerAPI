package com.elciocestari.drinksmanagerapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body("teste");
    }

    @PostMapping
    public ResponseEntity save(){
        return ResponseEntity.ok().body("teste");
    }
}
