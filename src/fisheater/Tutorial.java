package fisheater;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.MouseEvent;

public class Tutorial extends JPanel {

    private String backgroundImageUrl = "fisheater/resources/menus/Tutorial.jpg";

    int[] backBtn = { 471, 456, 545, 824 };

    public Tutorial(int width, int height) {
        setSize(width, height);
        setLocation(0, 0);
    }

    public Image getBackgroundImage() {
        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(backgroundImageUrl));
        return ii.getImage();
    }

    public boolean backPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < backBtn[1] || x > backBtn[3])
            return false;
        if (y < backBtn[0] || y > backBtn[2])
            return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
