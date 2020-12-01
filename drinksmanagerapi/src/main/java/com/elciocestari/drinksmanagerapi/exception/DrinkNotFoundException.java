package com.elciocestari.drinksmanagerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DrinkNotFoundException extends Exception {

    public static final String MESSAGE = "Não existe essa bebida no sistema";

    public DrinkNotFoundException(Long id) {
        super(MESSAGE + " com id: " + id);
    }

    public DrinkNotFoundException() {
        super(MESSAGE);
    }
}
