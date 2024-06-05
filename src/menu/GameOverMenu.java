package menu;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.MouseEvent;

public class GameOverMenu extends JPanel {

    private String backgroundImageUrl = "resources/menus/GameOver.png";

    int[] replayBtn = { 620, 31, 692, 245 };
    int[] menuBtn = { 620, 1026, 692, 1242 };
    JLabel scoreLabel;

    public GameOverMenu(int width, int height) {
        setSize(width, height);
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
