package com.elciocestari.drinksmanagerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExcepton extends Exception {

    public static final String MESSAGE = "Usuário não encontrado ";

    public UserNotFoundExcepton(Long id) {
        super(MESSAGE + " com id: " + id);
    }

    public UserNotFoundExcepton() {
        super(MESSAGE);
    }
}
