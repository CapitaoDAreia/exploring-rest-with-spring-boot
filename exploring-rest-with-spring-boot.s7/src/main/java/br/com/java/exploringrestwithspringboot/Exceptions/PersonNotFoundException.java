package br.com.java.exploringrestwithspringboot.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public PersonNotFoundException(String exception){
        super(exception);
    }
}
