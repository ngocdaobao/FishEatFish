package src;

import javax.swing.*;

import javafx.scene.input.MouseEvent;

/**
 * Welcome
 */
public class Welcome extends JPanel {

    private String backgroundImageUrl = "assets/images/Welcome.jpg";

    int[] startBtn = {262,458,335,827}; // top left down right
    int[] tutorialBtn = {369,458,443,827};
    int[] quitBtn = {477,458,551,827};

    public Welcome(int Width, int Height) {
        setSize(Width, Height);
        setLocation(0,0);
    }
    
    public BackgroundImage getBackgroundImage() {
        return new BackgroundImage(backgroundImageUrl);
    }

    public boolean startPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if(x < startBtn[0] || x > startBtn[2])return false;
        if(y < startBtn[1] || y > startBtn[3])return false;
        return true;
    }

    public boolean tutorialPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if(x < tutorialBtn[0] || x > tutorialBtn[2])return false;
        if(y < tutorialBtn[1] || y > tutorialBtn[3])return false;
        return true;
    }

    public boolean quitPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if(x < quitBtn[0] || x > quitBtn[2])return false;
        if(y < quitBtn[1] || y > quitBtn[3])return false;
        return true;
    }
}