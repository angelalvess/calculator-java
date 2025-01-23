package com.angie.calculator.view;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JPanel {


    private final Color LIGHT_GRAY = new Color(99, 99, 99);
    private final Color DARK_GRAY = new Color(68, 68, 68);
    private final Color ORANGE = new Color(242, 163, 60);

    public Keyboard () {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        setLayout(layout);

        addButton("AC", DARK_GRAY, constraints, 0, 0);
        addButton("+/-", DARK_GRAY, constraints, 1, 0);
        addButton("%", DARK_GRAY, constraints, 2, 0);
        addButton("/", ORANGE, constraints, 3, 0);

        addButton("7", LIGHT_GRAY, constraints, 0, 1);
        addButton("8", LIGHT_GRAY, constraints, 1, 1);
        addButton("9", LIGHT_GRAY, constraints, 2, 1);
        addButton("x", ORANGE, constraints, 3, 1);


        addButton("4", LIGHT_GRAY, constraints, 0, 2);
        addButton("5", LIGHT_GRAY, constraints, 1, 2);
        addButton("6", LIGHT_GRAY, constraints, 2, 2);
        addButton("-", ORANGE, constraints, 3, 2);

        addButton("1", LIGHT_GRAY, constraints, 0, 3);
        addButton("2", LIGHT_GRAY, constraints, 1, 3);
        addButton("3", LIGHT_GRAY, constraints, 2, 3);
        addButton("+", ORANGE, constraints, 3, 3);

        addButton("0", LIGHT_GRAY, constraints, 0, 4);
        addButton("0", LIGHT_GRAY, constraints, 1, 4);
        addButton(",", LIGHT_GRAY, constraints, 2, 4);
        addButton("=", ORANGE, constraints, 3, 4);


    }

    private void addButton (String text, Color color, GridBagConstraints c, int x, int y) {

        c.gridx = x;
        c.gridy = y;

        Button button = new Button(text, color);
        add(button, c);
    }
}