package com.angie.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {


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


    public void processCommand (String value) {

        if ("AC".equals(value)) {
            currentText = "";
        } else {
            currentText += value;
        }

        observers.stream().forEach(observer -> observer.changedValue(getCurrentText()));
    }

}
