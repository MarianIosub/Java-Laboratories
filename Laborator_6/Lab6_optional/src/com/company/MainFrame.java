package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    ShapePanel shapePanel;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        shapePanel=new ShapePanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(canvas, CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(shapePanel, BorderLayout.WEST);
        pack();
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }
}
