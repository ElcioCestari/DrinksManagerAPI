package com.elciocestari.drinksmanagerapi.service;

import com.elciocestari.drinksmanagerapi.entity.User;
import com.elciocestari.drinksmanagerapi.exception.UserNotFoundExcepton;
import com.elciocestari.drinksmanagerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User getById(Long id) throws UserNotFoundExcepton {
        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundExcepton(id));
    }

    public List<User> getAll(){ return userRepository.findAll(); }

}
