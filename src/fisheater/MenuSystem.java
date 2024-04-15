
package fisheater;

import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class MenuSystem
{
    private int[] positionX, endPositionX;
    private int positionY, endPositionY;
    private int width;
    private int height;
    private String title;
    
    private Image mainMenu, gameOver;
    private String fishmenu = "fisheater/resources/menus/fisheatermenu.png";
    private String gameovermenu = "fisheater/resources/menus/gameOver.png";

    private boolean start, menu, replay;


    public MenuSystem(int width, int height)
    {
        this.width = width;
        this.height = height;

        start = false;
        menu = false;
        replay = false;
        
        positionX = new int[3];
        endPositionX = new int[3];
        
        positionX[0] = 350;
        endPositionX[0] = 450;
        
        positionX[1] = 100;
        endPositionX[1] = 250;
        
        positionX[2] = 500;
        endPositionX[2] = 650;
        
        positionY = 250;
        endPositionY = 300;
        
        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(fishmenu));
        mainMenu = ii.getImage();
        
        ImageIcon ic = new ImageIcon(getClass().getClassLoader().getResource(gameovermenu));
        gameOver = ic.getImage();
       

    }

    public Image getMenu()
    {
        return mainMenu;
    }
    
    public Image getGameOver()
    {
        return gameOver;
    }

    public boolean startPressed(MouseEvent m)
    {
        int x = m.getX();
        int y = m.getY();

        if( (x >= positionX[0]) && (x <= endPositionX[0]) && (y >= positionY) && (y <= endPositionY))
        {
            start = true;
        }
        else
        {
            start = false;
        }

        return start;
    }
    
    public boolean replayPressed(MouseEvent m)
    {
        int x = m.getX();
        int y = m.getY();
        
        if( (x >= positionX[1]) && (x <= endPositionX[1]) && (y >= positionY) && (y <= endPositionY))
        {
            replay = true;
        }
        else
        {
            replay = false;
        }
        
        return replay;
    }
    
    public boolean menuPressed(MouseEvent m)
    {
        int x = m.getX();
        int y = m.getY();
        
        if( (x >= positionX[2]) && (x <= endPositionX[2]) && (y >= positionY) && (y <= endPositionY))
        {
            menu = true;
        }
        else
        {
            menu = false;
        }
        
        return menu;
    }

    public void mouseReleased(MouseEvent m)
    {
    }

}
