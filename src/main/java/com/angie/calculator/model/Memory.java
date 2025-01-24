package com.angie.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {


    private enum TypeCommand {
        CLEAN, NUMBER, DIVIDE, MULTIPLY, SUBTRACT, SUMM, EQUALS, COMMA;
    }

    private static final Memory instancie = new Memory();
    private final List<MemoryObserver> observers = new ArrayList<>();

    private String currentText = "";

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

        System.out.println(detectTypeCommand(text));
        if ("AC".equals(text)) {
            currentText = "";
        } else {
            currentText += text;
        }

        observers.stream().forEach(observer -> observer.changedValue(getCurrentText()));
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
            } else if (",".equals(text)) {
                return TypeCommand.COMMA;
            } else if ("=".equals(text)) {
                return TypeCommand.EQUALS;
            }
        }

        return null;
    }

}

