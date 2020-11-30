package com.elciocestari.drinksmanagerapi.repository;

import com.elciocestari.drinksmanagerapi.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
