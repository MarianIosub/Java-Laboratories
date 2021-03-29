package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShapePanel extends JPanel{
    final MainFrame frame;
    JButton squareBtn = new JButton("Square");
    JButton triangleBtn = new JButton("Triangle");
    JButton circleBtn = new JButton("Circle");

    public ShapePanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){

        squareBtn.addActionListener(this::squareSet);
        triangleBtn.addActionListener(this::triangleSet);
        circleBtn.addActionListener(this::circleSet);
        add(squareBtn);
        add(triangleBtn);
        add(circleBtn);
    }
    private void squareSet(ActionEvent e){
        frame.configPanel.setSidesField(4);
    }
    private void triangleSet(ActionEvent e){
        frame.configPanel.setSidesField(3);
    }
    private void circleSet(ActionEvent e){
        frame.configPanel.setSidesField(100);
    }
}