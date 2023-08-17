package br.com.java.exploringrestwithspringboot.Services;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MathServices {
    public Double sum(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new Exception("Invalid number has found");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @Contract(pure = true)
    private @NotNull String replaceString(@NotNull String strNumber){
        return strNumber.replace(",", ".");
    }

    private @NotNull Double convertToDouble(String strNumber){
        if(strNumber == null) return 0D;
        String number = replaceString(strNumber);
        return Double.parseDouble(number);
    }

    @Contract(pure = true)
    private @NotNull Boolean isNumeric(String strNumber){
        String number = replaceString(strNumber);
        try{
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
