package fisheater;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.MouseEvent;

/**
 * Welcome
 */
public class HighScoreMenu extends JPanel {

    private String backgroundImageUrl = "fisheater/resources/menus/TopScore.png";

    int[] replayBtn = { 620, 30, 690, 250 }; // top left down right
    int[] menuBtn = { 620, 1030, 690, 1240 };

    public HighScoreMenu(int Width, int Height) {
        setSize(Width, Height);
        setLocation(0, 0);
    }

    public Image getBackgroundImage() {
        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(backgroundImageUrl));
        return ii.getImage();
    }

    public boolean replayPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < replayBtn[1] || x > replayBtn[3])
            return false;
        if (y < replayBtn[0] || y > replayBtn[2])
            return false;
        return true;
    }

    public boolean menuPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < menuBtn[1] || x > menuBtn[3])
            return false;
        if (y < menuBtn[0] || y > menuBtn[2])
            return false;
        return true;
    }
}