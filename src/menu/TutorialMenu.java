package menu;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.MouseEvent;

public class TutorialMenu extends JPanel {

    private String backgroundImageUrl = "resources/menus/Tutorial.jpg";

    int[] homeBtn = { 613, 16, 696, 253 };
    int[] playBtn = { 613, 1072, 696, 1260 };

    public TutorialMenu(int width, int height) {
        setSize(width, height);
        setLocation(0, 0);
    }

    public Image getBackgroundImage() {
        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(backgroundImageUrl));
        return ii.getImage();
    }

    public boolean homePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < homeBtn[1] || x > homeBtn[3])
            return false;
        if (y < homeBtn[0] || y > homeBtn[2])
            return false;
        return true;
    }

    public boolean playPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < playBtn[1] || x > playBtn[3])
            return false;
        if (y < playBtn[0] || y > playBtn[2])
            return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
