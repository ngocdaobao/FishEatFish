package src;

import javax.swing.*;
import java.awt.*;


public class BackgroundImage extends JPanel {
    private Image backgroundImage;

    // Constructor for the panel, accepts image path as parameter
    public BackgroundImage(String imagePath) {
        ImageIcon ic = new ImageIcon(imagePath);
        backgroundImage = ic.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image at the top-left corner
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}