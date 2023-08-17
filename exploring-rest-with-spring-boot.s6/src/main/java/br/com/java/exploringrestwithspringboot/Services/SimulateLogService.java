package br.com.java.exploringrestwithspringboot.Services;

import br.com.java.exploringrestwithspringboot.Domain.MathEnums;

public class SimulateLogService {
    public void logInfo(MathEnums operation, String info){
        String message = operation + ": " + info;
        System.out.println(message);
    }
}
