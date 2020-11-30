package com.elciocestari.drinksmanagerapi.service;

import com.elciocestari.drinksmanagerapi.entity.User;
import com.elciocestari.drinksmanagerapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class UserServiceTest {

    private UserRepository userRepository;

    private UserService userService;

    @Test
    public void testSave(){

        userRepository = mock(UserRepository.class);
        userService = mock(UserService.class);
        User userActual = User.builder()
                .login("Elciotaira@gmail.com")
                .name("Elcio")
                .password("Elcio123")
                .build();


        when(userRepository.save(userActual)).thenReturn(userActual);

        when(userService.save(userActual)).thenReturn(userActual);

        User userSave = userService.save(userActual);

        assertEquals(userSave.getLogin(), userActual.getLogin());
    }
}
