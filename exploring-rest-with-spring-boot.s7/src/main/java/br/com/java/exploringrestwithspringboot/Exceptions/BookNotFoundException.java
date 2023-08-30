package br.com.java.exploringrestwithspringboot.Exceptions;

import java.io.Serial;

public class BookNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public BookNotFoundException(String exception){super(exception);}
}
