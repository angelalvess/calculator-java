package com.angie.calculator.view;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button (String text, Color color) {
        setText(text);
        setOpaque(true);
        setBackground(color);
        setFont(new Font("courier", Font.PLAIN, 30));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setForeground(Color.WHITE);

    }
}
