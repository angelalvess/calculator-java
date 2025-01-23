package com.angie.calculator.model;

public class Memory {


    private static final Memory instancie = new Memory();

    private String currentText = "";

    private Memory () {
    }

    public static Memory getInstance() {
        return instancie;
    }

    public String getCurrentText () {
        return currentText.isEmpty() ? "0" : currentText;
    }
}
