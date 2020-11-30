package com.elciocestari.drinksmanagerapi.controller;

import com.elciocestari.drinksmanagerapi.entity.User;
import com.elciocestari.drinksmanagerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity save(@RequestBody User user){
        return ResponseEntity.ok().body(userService.save(user));
    }
}
