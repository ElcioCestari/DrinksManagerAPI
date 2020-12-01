package com.elciocestari.drinksmanagerapi.service;

import com.elciocestari.drinksmanagerapi.entity.User;
import com.elciocestari.drinksmanagerapi.exception.UserNotFoundExcepton;
import com.elciocestari.drinksmanagerapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testSave(){

        User userExpected = User.builder()
                .id(1L)
                .login("Elciotaira@gmail.com")
                .name("Elcio")
                .password("Elcio123")
                .build();

        when(userRepository.save(userExpected)).thenReturn(userExpected);

        User userActual = userService.save(userExpected);

        assertEquals(userExpected.getLogin(), userActual.getLogin());
    }


    @Test
    public void testGetUserById_whenUserIsFound() {

        User userExpected = User.builder()
                .id(1L)
                .name("Elcio")
                .login("elcio@gmail.com")
                .password("123senha")
                .build();

        when(userRepository.findById(userExpected.getId()))
                .thenReturn(Optional.of(userExpected));

        User userActual = null;
        try {
            userActual = userService.getById(userExpected.getId());
        } catch (UserNotFoundExcepton userNotFoundExcepton) {
            userNotFoundExcepton.printStackTrace();
            fail (userNotFoundExcepton.getMessage());
        }

        assertEquals(userExpected.getId(), userActual.getId());

    }

    @Test
    public void testGetUserById_whenUserIsNotFoundThenThrowException(){

        Long noneExistent = 10L;

        when(userRepository.findById(noneExistent))
                .thenReturn(Optional.ofNullable(any(User.class)));

        assertThrows(UserNotFoundExcepton.class, () -> userService.getById(noneExistent)  );

    }
}
