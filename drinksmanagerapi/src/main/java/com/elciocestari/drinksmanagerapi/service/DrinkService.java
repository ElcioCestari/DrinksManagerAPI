package com.elciocestari.drinksmanagerapi.service;

import com.elciocestari.drinksmanagerapi.entity.Drink;
import com.elciocestari.drinksmanagerapi.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    public Drink save(Drink drink){
        return this.drinkRepository.save(drink);
    }

    public List<Drink> findAll(){ return this.drinkRepository.findAll(); }

    public void delete(Long id){
        this.drinkRepository.deleteById(id);
    }
}
