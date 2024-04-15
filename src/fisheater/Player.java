package fisheater;

import java.awt.event.KeyEvent;

public class Player extends CoreObject 
{
	private int speed;
	private String icon = "fisheater/resources/fish/smallPlayer";
	private boolean speedUp = false,
					sharkEat= false;
	
	public Player(int x, int y, int playerSpeed)
	{
        super(x,y);
        String temp = "";
        
		temp = icon + "R" + ".png";
		this.genImage(temp);
                
                this.center = new Center();
		
		this.speed = playerSpeed;
	}
	
	public void setSpeedUp(boolean b)
	{ speedUp = b; }
	
	public void setSharkEat(boolean b)
	{ sharkEat = b; }
    
    public boolean getSharkEat()
    {
        return this.sharkEat;
    }
    
    public boolean getSpeedUp()
    {
        return this.speedUp;
    }
	
	public void move()
	{
		super.move();
                
            if(this.dx > 0 && this.speedUp)
                this.dx = 2*speed;
            else if (this.dx < 0 && this.speedUp)
                this.dx = -2*speed;

            if(this.dy > 0 && this.speedUp)
                this.dy = 2*speed;
            else if (this.dy < 0 && this.speedUp)
                this.dy = -2*speed;

            if(this.x < 1)
            {
                this.x = 1;
                this.center.centerX = 1 + this.center.getCTEX();
            }
            if(this.x > (800-this.width*2))
            {
                this.x = (800-this.width*2);
                this.center.centerX = this.x + this.center.getCTEX();
                 
            }
            if(this.y < 1)
            {
                this.y = 1;
                this.center.centerY = 1 + this.center.getCTEY();
            }
            if(this.y > (600-this.height*2))
            {
                this.y = (600-this.height*2);
                this.center.centerY = this.y + this.center.getCTEY();
            }
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
        String temp = "";
		
        if(key == KeyEvent.VK_Q)
        {
            System.exit(0);
        }
		if(key == KeyEvent.VK_A)
		{ 
            this.dx = -this.speed;
            temp = icon + "L" + ".png";
            this.genImage(temp);
        }
		if(key == KeyEvent.VK_D)
		{ 
            this.dx =  this.speed; 
            temp = icon + "R" + ".png";
            this.genImage(temp);
        }
		if(key == KeyEvent.VK_W)
		{ this.dy = -this.speed; }
		if(key == KeyEvent.VK_S)
		{ this.dy =  this.speed; }	
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A)
		{ this.dx = 0; }
		if(key == KeyEvent.VK_D)
		{ this.dx = 0; }
		if(key == KeyEvent.VK_W)
		{ this.dy = 0; }
		if(key == KeyEvent.VK_S)
		{ this.dy = 0; }
	}
}
