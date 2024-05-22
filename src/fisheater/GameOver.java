package fisheater;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.MouseEvent;

public class GameOver extends JPanel {

    private String backgroundImageUrl = "fisheater/resources/menus/GameOver.png";

    int[] replayBtn = { 432, 458, 506, 827 };
    JLabel scoreLabel;

    public GameOver(int width, int height) {
        setSize(width, height);
        setLocation(0, 0);
        setScore(0);
    }

    public Image getBackgroundImage() {
        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(backgroundImageUrl));
        return ii.getImage();
    }

    public void setScore(int score) {
        scoreLabel = new JLabel(String.valueOf(score));
        scoreLabel.setSize(50, 100);
        scoreLabel.setLocation(500, 100);
        add(scoreLabel);
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
}
