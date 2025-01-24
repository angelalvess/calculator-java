package com.angie.calculator.view;

import com.angie.calculator.model.Memory;
import com.angie.calculator.model.MemoryObserver;

import javax.swing.*;
import java.awt.*;


public class Display extends JPanel implements MemoryObserver {



    private final JLabel label;

    public Display () {
        Memory.getInstance().registerObservers(this);

        setBackground(new Color(46, 49, 50));

        label = new JLabel(Memory.getInstance().getCurrentText());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 21, 17));
        add(label);
    }

    @Override
    public void changedValue (String newValue) {
        label.setText(newValue);
    }
}
