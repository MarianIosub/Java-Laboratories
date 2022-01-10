package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Random;

public class DrawingPanel extends JPanel implements ImageObserver {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        int radius = (int) frame.configPanel.getSizeFields().getValue();
        int sides = (int) frame.configPanel.getSidesField().getValue();
        Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.RED, Color.GREEN, Color.ORANGE, Color.PINK, Color.magenta, Color.YELLOW, Color.WHITE};
        //color of figure
        Random random = new Random();
        Color color;

        if (frame.configPanel.getColorCombo().getSelectedIndex() > 0) {
            color = colors[frame.configPanel.getColorCombo().getSelectedIndex() - 1];
        } else {
            color = colors[random.nextInt(colors.length)];
        }

        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
        //color of stroke of figure
        if (frame.configPanel.getStrokeCombo().getSelectedIndex() > 0) {
            color = colors[frame.configPanel.getStrokeCombo().getSelectedIndex() - 1];
        } else {
            color = colors[random.nextInt(colors.length)];
        }

        graphics.setColor(color);
        graphics.draw(new RegularPolygon(x, y, radius, sides));
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        repaint();
    }

    public void resetImage() {

        BufferedImage image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        this.image = image;
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        repaint();
    }
}

