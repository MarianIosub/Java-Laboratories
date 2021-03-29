package com.company;

import javax.swing.*;


public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JSpinner sizeFields;
    JComboBox colorCombo;
    JComboBox strokeCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        String[] colors = {"RANDOM", "BLACK", "BLUE", "CYAN", "RED", "GREEN", "ORANGE", "PINK", "MAGENTA", "YELLOW", "WHITE"};

        JLabel sizeLabel = new JLabel("The size: ");
        JLabel sidesLabel = new JLabel("Number of sides: ");
        JLabel colorLabel = new JLabel("Color of your shape: ");
        JLabel strokeLabel = new JLabel("Color of the stroke of your shape: ");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sizeFields = new JSpinner(new SpinnerNumberModel(30, 1, 200, 10));
        colorCombo = new JComboBox(colors);
        strokeCombo = new JComboBox(colors);
        add(sidesLabel);
        add(sidesField);
        add(sizeLabel);
        add(sizeFields);
        add(colorLabel);
        add(colorCombo);
        add(strokeLabel);
        add(strokeCombo);

    }

    public MainFrame getFrame() {
        return frame;
    }

    public JLabel getLabel() {
        return label;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public JSpinner getSizeFields() {
        return sizeFields;
    }

    public JComboBox getStrokeCombo() {
        return strokeCombo;
    }

    public void setSidesField(Integer noOfSides) {
        this.sidesField.setValue(noOfSides);
    }
}

