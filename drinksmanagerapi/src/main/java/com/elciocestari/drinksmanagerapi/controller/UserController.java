package com.elciocestari.drinksmanagerapi.controller;

import com.elciocestari.drinksmanagerapi.entity.User;
import com.elciocestari.drinksmanagerapi.service.UserService;
import com.elciocestari.drinksmanagerapi.service.exception.UserNotFoundExcepton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity save(@RequestBody User user){
        return ResponseEntity.ok().body(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) throws UserNotFoundExcepton {
        return ResponseEntity.ok().body(userService.getById(id));
    }
}
