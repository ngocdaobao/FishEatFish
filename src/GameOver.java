package src;

import javax.swing.*;

import javafx.scene.input.MouseEvent;

public class GameOver extends JPanel {
    
    private String backgroundImageUrl = "assets/images/GameOver.JPG";

    int[] replayBtn = {432, 458, 506, 827};
    JLabel scoreLabel;
    
    public GameOver(int width, int height) {
        setSize(width, height);
        setLocation(0,0);
        setScore(0);
    }

    public BackgroundImage getBackgroundImage() {
        return new BackgroundImage(backgroundImageUrl);
    }

    public void setScore(int score) {
        scoreLabel = new JLabel(String.valueOf(score));
        scoreLabel.setSize(50, 100);
        scoreLabel.setLocation(500,100);
        add(scoreLabel);
    }
    
    public boolean replayPressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if(x < replayBtn[0] || x > replayBtn[2])return false;
        if(y < replayBtn[1] || y > replayBtn[3])return false;
        return true;
    }
    public static void main(String[] args) {
        
    }
}
