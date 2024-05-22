package fisheater;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.MouseEvent;

/**
 * Welcome
 */
public class WelcomeMenu extends JPanel {

    private String backgroundImageUrl = "fisheater/resources/menus/Welcome.png";

    int[] startBtn = { 238, 456, 359, 821 }; // top left down right
    int[] tutorialBtn = { 374, 456, 494, 821 };
    int[] highScoreBtn = { 506, 456, 625, 821 };

    public WelcomeMenu(int Width, int Height) {
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

    public boolean highScorePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < highScoreBtn[1] || x > highScoreBtn[3])
            return false;
        if (y < highScoreBtn[0] || y > highScoreBtn[2])
            return false;
        return true;
    }
}