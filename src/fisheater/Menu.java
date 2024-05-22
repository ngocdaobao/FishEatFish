package fisheater;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.event.MouseEvent;

/**
 * Menu
 */
public class Menu extends JPanel {

    WelcomeMenu welcome;
    TutorialMenu tutorial;
    GameOverMenu gameOver;
    HighScoreMenu highScore;
    EnterNameMenu enterName;

    boolean isWelcome, isGameOver, isTutorial, isHighScore, isEnterName;

    public Menu(int width, int height) {
        welcome = new WelcomeMenu(width, height);
        tutorial = new TutorialMenu(width, height);
        gameOver = new GameOverMenu(width, height);
        highScore = new HighScoreMenu(width, height);
        enterName = new EnterNameMenu(width, height);

        isWelcome = true;
        isGameOver = false;
        isTutorial = false;
        isHighScore = false;
        isEnterName = false;
    }

    public void setCurrentMenu(String str) {
        isWelcome = false;
        isGameOver = false;
        isTutorial = false;
        isHighScore = false;
        isEnterName = false;
        if (str == "welcome")
            isWelcome = true;
        if (str == "gameOver")
            isGameOver = true;
        if (str == "tutorial")
            isTutorial = true;
        if (str == "highScore")
            isHighScore = true;
        if (str == "enterName")
            isEnterName = true;
    }

    public Image getMenuBackgroundImage(String str) {
        if (str == "welcome")
            return welcome.getBackgroundImage();
        if (str == "tutorial")
            return tutorial.getBackgroundImage();
        if (str == "highScore")
            return highScore.getBackgroundImage();
        if (str == "gameOver")
            return gameOver.getBackgroundImage();
        if (str == "enterName")
            return enterName.getBackgroundImage();
        return tutorial.getBackgroundImage();
    }

    public boolean startPressed(MouseEvent e) {
        if (isWelcome)
            return welcome.startPressed(e);
        if (isTutorial)
            return tutorial.playPressed(e);
        return false;
    }

    public boolean tutorialPressed(MouseEvent e) {
        return welcome.tutorialPressed(e);
    }

    public boolean highScorePressed(MouseEvent e) {
        return welcome.highScorePressed(e);
    }

    public boolean replayPressed(MouseEvent e) {
        return gameOver.replayPressed(e);
    }

    public boolean menuPressed(MouseEvent e) {
        if (isGameOver)
            return gameOver.menuPressed(e);
        if (isTutorial)
            return tutorial.homePressed(e);
        if (isHighScore)
            return highScore.menuPressed(e);
        return false;
    }

    public boolean submitNamePressed(MouseEvent e) {
        return enterName.submitNamePressed(e);
    }

    public static void main(String[] args) {

    }
}