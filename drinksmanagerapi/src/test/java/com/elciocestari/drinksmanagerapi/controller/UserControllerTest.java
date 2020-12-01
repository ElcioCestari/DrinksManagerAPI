package com.elciocestari.drinksmanagerapi.controller;

import com.elciocestari.drinksmanagerapi.repository.UserRepository;
import com.elciocestari.drinksmanagerapi.service.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

}
