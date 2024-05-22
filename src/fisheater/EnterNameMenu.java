package fisheater;

import javax.swing.*;
import java.awt.Image;
import java.awt.event.MouseEvent;

public class EnterNameMenu extends JPanel {

    private String backgroundImageUrl = "fisheater/resources/menus/EnterName.png";

    int[] submitNameBtn = { 600, 532, 673, 750 };

    public EnterNameMenu(int width, int height) {
        setSize(width, height);
        setLocation(0, 0);
    }

    public Image getBackgroundImage() {
        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(backgroundImageUrl));
        return ii.getImage();
    }

    public boolean submitNamePressed(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        if (x < submitNameBtn[1] || x > submitNameBtn[3])
            return false;
        if (y < submitNameBtn[0] || y > submitNameBtn[2])
            return false;
        return true;
    }
}
