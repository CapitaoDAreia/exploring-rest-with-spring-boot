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
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        this.logService.logInfo(MathEnums.SUM_RECEIVED, numberOne + "+" + numberTwo);
        Double result = this.mathService.sum(numberOne, numberTwo);
        this.logService.logInfo(MathEnums.SENDING_SUM_RESULT, result.toString());
        return result;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        this.logService.logInfo(MathEnums.SUB_RECEIVED, numberOne + "-" + numberTwo);
        Double result = this.mathService.sub(numberOne, numberTwo);
        this.logService.logInfo(MathEnums.SENDING_SUB_RESULT, result.toString());
        return result;
    }

    @RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        this.logService.logInfo(MathEnums.MUL_RECEIVED, numberOne + "-" + numberTwo);
        Double result = this.mathService.mul(numberOne, numberTwo);
        this.logService.logInfo(MathEnums.SENDING_MUL_RESULT, result.toString());
        return result;
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        this.logService.logInfo(MathEnums.MED_RECEIVED, numberOne + " and " + numberTwo);
        Double result = this.mathService.med(numberOne, numberTwo);
        this.logService.logInfo(MathEnums.SENDING_MED_RESULT, result.toString());
        return result;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        this.logService.logInfo(MathEnums.DIV_RECEIVED, numberOne + "/" + numberTwo);
        Double result = this.mathService.div(numberOne, numberTwo);
        this.logService.logInfo(MathEnums.SENDING_DIV_RESULT, result.toString());
        return result;
    }

    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
    public Double sRoot(@PathVariable(value = "number") String number) {
        this.logService.logInfo(MathEnums.SQUARE_ROOT_RECEIVED, number);
        Double result = this.mathService.sRoot(number);
        this.logService.logInfo(MathEnums.SENDING_SQUARE_ROOT_RESULT, result.toString());
        return result;
    }
}