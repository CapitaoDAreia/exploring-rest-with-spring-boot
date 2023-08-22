package br.com.java.exploringrestwithspringboot.Services;

import br.com.java.exploringrestwithspringboot.Exceptions.UnsupportedMathOperationException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class MathServices {
    public Double sum(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number has found");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number has found");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number has found");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mul(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number has found");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double med(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number has found");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double sRoot(String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Invalid number has found");
        }
        return Math.sqrt(convertToDouble(number));
    }

    @Contract(pure = true)
    private @NotNull String replaceString(@NotNull String strNumber) {
        return strNumber.replace(",", ".");
    }

    private @NotNull Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = replaceString(strNumber);
        return Double.parseDouble(number);
    }

    @Contract(pure = true)
    private @NotNull Boolean isNumeric(String strNumber) {
        String number = replaceString(strNumber);
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
