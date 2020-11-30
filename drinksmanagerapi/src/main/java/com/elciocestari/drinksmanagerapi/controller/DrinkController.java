package com.elciocestari.drinksmanagerapi.controller;

import com.elciocestari.drinksmanagerapi.entity.Drink;
import com.elciocestari.drinksmanagerapi.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(this.drinkService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Drink drink){
        return ResponseEntity.ok().body(this.drinkService.save(drink));
    }
}
