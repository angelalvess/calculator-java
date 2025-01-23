package com.angie.calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {


    public Calculator ()  {


        setSize(332, 422);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main (String[] args) {
    new Calculator();
    }
}
