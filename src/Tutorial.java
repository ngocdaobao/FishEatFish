package src;

import javax.swing.*;

import javafx.scene.input.MouseEvent;

public class Tutorial extends JPanel {
    
    private String backgroundImageUrl = "assets/images/Tutorial.jpg";

    int[] backBtn = {471, 456, 545, 824};
    
    public Tutorial(int width, int height) {
        setSize(width, height);
        setLocation(0,0);
    }

    public BackgroundImage getBackgroundImage() {
        return new BackgroundImage(backgroundImageUrl);
    }

    public boolean backPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if(x < backBtn[0] || x > backBtn[2])return false;
        if(y < backBtn[1] || y > backBtn[3])return false;
        return true;
    }
    public static void main(String[] args) {
        
    }
}
