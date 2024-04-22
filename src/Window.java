package src;

import java.awt.BorderLayout;

/**
 * Window
 */
import javax.swing.*;

public class Window extends JFrame {

    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    Menu menu;

    public Window(int width, int height) {
        setSize(width, height);

        menu = new Menu(width, height);
        menu.setMenu("gameover");

        setContentPane(menu.getBackgroundImage());
        setResizable(false);
        setVisible(true);
    }

    public void changeWindow() {
        setContentPane(menu.getBackgroundImage());
        add(menu.getMenu());
    }
    public static void main(String[] args) {
        new Window(WIDTH, HEIGHT);
    }   
    
}