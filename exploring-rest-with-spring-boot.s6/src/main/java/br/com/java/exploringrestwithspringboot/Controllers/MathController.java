package br.com.java.exploringrestwithspringboot.Controllers;

import br.com.java.exploringrestwithspringboot.Domain.MathEnums;
import br.com.java.exploringrestwithspringboot.Services.MathServices;
import br.com.java.exploringrestwithspringboot.Services.SimulateLogService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    MathServices mathService = new MathServices();
    SimulateLogService logService = new SimulateLogService();
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum( @PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
        this.logService.logInfo(MathEnums.SUM_RECEIVED, numberOne + "+" + numberTwo);
        Double result = this.mathService.sum(numberOne, numberTwo);
        this.logService.logInfo(MathEnums.SENDING_SUM_RESULT, result.toString());
        return result;
    }
}