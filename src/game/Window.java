package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame {
    private final int WIDTH = 1280;
    private final int HEIGHT = 755;

    public Window() {
        add(new Panel(WIDTH, HEIGHT));
        ImageIcon icon = new ImageIcon("resources/menus/icon.png");

        setIconImage(icon.getImage());

        setTitle("Fish Eat Fish");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public static void main(String[] args) {
        new Window();
    }

}
