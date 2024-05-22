package fisheater;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.event.MouseEvent;

/**
 * Menu
 */
public class Menu extends JPanel {

    Welcome welcome;
    Tutorial tutorial;
    GameOver gameOver;

    boolean isStart, isReplay, isTutorial, isQuit;

    public Menu(int width, int height) {
        welcome = new Welcome(width, height);
        tutorial = new Tutorial(width, height);
        gameOver = new GameOver(width, height);

    }

    public Image getMenu(String str) {
        if (str == "welcome")
            return welcome.getBackgroundImage();
        if (str == "tutorial")
            return tutorial.getBackgroundImage();
        return gameOver.getBackgroundImage();
    }

    public boolean startPressed(MouseEvent e) {
        System.out.println(welcome.startPressed(e));
        return welcome.startPressed(e);
    }

    public boolean tutorialPressed(MouseEvent e) {
        return welcome.tutorialPressed(e);
    }

    public boolean quitPressed(MouseEvent e) {
        return welcome.quitPressed(e);
    }

    public boolean replayPressed(MouseEvent e) {
        return gameOver.replayPressed(e);
    }

    public boolean menuPressed(MouseEvent e) {
        return gameOver.replayPressed(e);
    }

    public static void main(String[] args) {

    }
}