
package fisheater;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;

public class PowerUp extends CoreObject
{
    private long duration;
    
    private String name;
    private String icon = "fisheater/resources/fish/algae.png";
    
    private int counter = 0;
    
    private boolean isAlive = false;
    
    public PowerUp(int x, int y, int speed)
    {
        super(x,y);
        
        this.genImage(icon);
        
        this.dx = 0;
        this.dy = speed;
        this.name = "";
        this.counter = 0;
        this.isAlive = true;
        
        this.center = new Center();
        
        genPower();
    }
    
    public void move()
    {
        super.move();
        
        if(this.y > 600)
        {
            this.isAlive = false;
        }
    }
    
    public void genPower()
    {
        Random gen = new Random();
        int pType = gen.nextInt(10);
        
        if(pType < 5)
        {
            name = "Speed Up";
            counter = 63*14;
        }
        if(pType > 5)
        {
            name = "Shark Eater";
            counter = 63*14;
        }
    }
    
    //when the player touches the power up
    //it's moved off screen and waits for duration
    //of the power up to end before producing another
    //power up
    public void setY(int y)
    {
        this.y = y;
        this.dy = 0;
    }
    
    public void setAlive(boolean b)
    {
        this.isAlive = b;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public boolean isAlive()
    {
        return this.isAlive;
    }
    
    public int getDuration()
    {
        counter--;
        return counter;
    }
}
