package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.io.File;

import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");
    JButton loadBtn = new JButton("Load");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        setLayout(new GridLayout(1, 4));
        saveBtn.addActionListener(this::save);
        exitBtn.addActionListener(this::exit);
        resetBtn.addActionListener(this::reset);
        loadBtn.addActionListener(this::load);
        add(saveBtn);
        add(exitBtn);
        add(resetBtn);
        add(loadBtn);

    }

    private void save(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Where do you want to save your drawing?");
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(chooser.getSelectedFile().getPath()));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

    private void reset(ActionEvent e) {

        frame.getCanvas().resetImage();
    }

    private void load(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("From where do you want to load your drawing?");
        FileNameExtensionFilter extension = new FileNameExtensionFilter("PNG", "png");
        chooser.setFileFilter(extension);
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                frame.getCanvas().setImage(ImageIO.read(chooser.getSelectedFile()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }


}

