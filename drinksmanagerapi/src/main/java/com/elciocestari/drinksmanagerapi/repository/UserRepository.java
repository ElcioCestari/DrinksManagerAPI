package com.elciocestari.drinksmanagerapi.repository;

import com.elciocestari.drinksmanagerapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
