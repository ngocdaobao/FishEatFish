package fisheater;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.MouseEvent;

/**
 * Welcome
 */
public class Welcome extends JPanel {

    private String backgroundImageUrl = "fisheater/resources/menus/Welcome.jpg";

    int[] startBtn = { 262, 458, 335, 827 }; // top left down right
    int[] tutorialBtn = { 369, 458, 443, 827 };
    int[] quitBtn = { 477, 458, 551, 827 };

    public Welcome(int Width, int Height) {
        setSize(Width, Height);
        setLocation(0, 0);
    }

    public Image getBackgroundImage() {
        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(backgroundImageUrl));
        return ii.getImage();
    }

    public boolean startPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < startBtn[1] || x > startBtn[3])
            return false;
        if (y < startBtn[0] || y > startBtn[2])
            return false;
        return true;
    }

    public boolean tutorialPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < tutorialBtn[1] || x > tutorialBtn[3])
            return false;
        if (y < tutorialBtn[0] || y > tutorialBtn[2])
            return false;
        return true;
    }

    public boolean quitPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < quitBtn[1] || x > quitBtn[3])
            return false;
        if (y < quitBtn[0] || y > quitBtn[2])
            return false;
        return true;
    }
}