package com.angie.calculator.view;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {


    private final JLabel label;

    public Display () {

        setBackground(new Color(46, 49, 50));

        label = new JLabel("123,56");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 21, 17));
        add(label);
    }
}
