package com.angie.calculator.view;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {


    public Calculator () {

        organizeLayout();

        setSize(332, 422);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void organizeLayout () {

        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension( 266, 90));
        add(display, BorderLayout.NORTH);

        Keyboard keyboard = new Keyboard();
        add(keyboard, BorderLayout.CENTER);

    }

    public static void main (String[] args) {
        new Calculator();
    }
}
