package src;

import javax.swing.JPanel;

import javafx.scene.input.MouseEvent;

/**
 * Menu
 */
public class Menu extends JPanel {

    Welcome welcome;
    Tutorial tutorial;
    GameOver gameOver;

    boolean isWelcome, isTutorial, isGameOver;

    public Menu(int width, int height) {
        welcome = new Welcome(width, height);
        tutorial = new Tutorial(width, height);
        gameOver = new GameOver(width, height);

        isWelcome = isTutorial = isGameOver = false;
        isWelcome = true;

    }

    public void setMenu(String str) {
        isWelcome = isTutorial = isGameOver = false;
        switch (str) {
            case "welcome":
                isWelcome = true;
                break;
            case "tutorial":
                isTutorial = true;
                break;
            case "gameover":
                isGameOver = true;
                break;
            default:
                throw new Error("setMenu(str): str was not in ['welcome', 'tutorial', 'gameover'] found '" + str + "'");
        }
    }

    public JPanel getMenu() {
        if (isWelcome)
            return welcome;
        if (isTutorial)
            return tutorial;
        if (isGameOver)
            return gameOver;
        return new JPanel();
    }

    public BackgroundImage getBackgroundImage() {
        if (isWelcome)
            return welcome.getBackgroundImage();
        if (isTutorial)
            return tutorial.getBackgroundImage();
        if (isGameOver)
            return gameOver.getBackgroundImage();
        return new BackgroundImage("DUMB BACKGROUND");
    }

    public boolean startPressed(MouseEvent e) {
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

    public static void main(String[] args) {

    }
}