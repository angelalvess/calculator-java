package com.angie.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {


    private enum TypeCommand {
        CLEAN, NUMBER, DIVIDE, MULTIPLY, SUBTRACT, SUMM, EQUALS, COMMA;
    }

    private static final Memory instancie = new Memory();
    private final List<MemoryObserver> observers = new ArrayList<>();

    private TypeCommand lastOperation = null;
    private boolean replace = false;
    private String currentText = "";
    private String bufferText = "";

    private Memory () {
    }

    public void registerObservers (MemoryObserver observer) {
        observers.add(observer);
    }


    public static Memory getInstance () {
        return instancie;
    }

    public String getCurrentText () {
        return currentText.isEmpty() ? "0" : currentText;
    }


    public void processCommand (String text) {

        TypeCommand typeCommand = detectTypeCommand(text);

        if (typeCommand == null) {
            return;
        } else if (typeCommand == TypeCommand.CLEAN) {
            currentText = "";
            bufferText = "";
            replace = false;
            lastOperation = null;
        } else if (typeCommand == TypeCommand.NUMBER || typeCommand == TypeCommand.COMMA) {
            currentText = replace ? text : currentText + text; // text equilave as op
            replace = false;
        } else {
            replace = true;
            currentText = obtainOperationResults();
            bufferText = currentText;
            lastOperation = typeCommand;

        }

        observers.stream().forEach(observer -> observer.changedValue(getCurrentText()));
    }


    private String obtainOperationResults () {

        if (lastOperation == null || lastOperation == TypeCommand.EQUALS) {
            return currentText;
        }

        double bufferNumber = Double.parseDouble(bufferText.replace(",", "."));
        double currentNumber = Double.parseDouble(currentText.replace(",", "."));


        double result = 0;

        if (lastOperation == TypeCommand.SUMM) {
            result = bufferNumber + currentNumber;
        } else if (lastOperation == TypeCommand.SUBTRACT) {
            result = bufferNumber - currentNumber;
        } else if (lastOperation == TypeCommand.MULTIPLY) {
            result = bufferNumber * currentNumber;
        } else if (lastOperation == TypeCommand.DIVIDE) {
            result = bufferNumber / currentNumber;
        }


        String resultString = Double.toString(result).replace(".", ",");


        boolean resultInt = resultString.endsWith(",0");

        return resultInt ? resultString.replace(",0", "") : resultString;
    }

    private TypeCommand detectTypeCommand (String text) {
        if (currentText.isEmpty() && text == "0") {
            return null;
        }


        try {
            Integer.parseInt(text);
            return TypeCommand.NUMBER;
        } catch (NumberFormatException e) {
            if ("AC".equals(text)) {
                return TypeCommand.CLEAN;
            } else if ("/".equals(text)) {
                return TypeCommand.DIVIDE;
            } else if ("x".equals(text)) {
                return TypeCommand.MULTIPLY;
            } else if ("+".equals(text)) {
                return TypeCommand.SUMM;
            } else if ("-".equals(text)) {
                return TypeCommand.SUBTRACT;
            } else if (",".equals(text) && !currentText.contains(",")) {
                return TypeCommand.COMMA;
            } else if ("=".equals(text)) {
                return TypeCommand.EQUALS;
            }
        }

        return null;
    }

}

