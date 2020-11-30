package com.elciocestari.drinksmanagerapi.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserTest {

    @Mock
    private User userTestMock;

    @Test
    public void testGetName(){

        String expected = "Elcio";

        User user = mock(User.class);

        when(user.getName()).thenReturn(expected);

        String actual = user.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void testAllAtributes(){

    }
}
