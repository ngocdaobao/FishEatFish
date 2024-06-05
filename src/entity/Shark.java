package entity;

import java.awt.Rectangle;

public class Shark extends Entity
{
	private String icon = "resources/fish/Shark";
	private int points = 25;
	
	public Shark(int x, int y, int speed, String direction)
	{
		super(x,y);
		
        icon += direction + ".png";
		this.genImage(icon);
                this.height = 2 * this.height / 3;
                
                this.center = new Center();
		
		this.dy = 0;
		this.dx = -speed;		
	}
	
    public int getSpeed()
    { 
        return this.dx; 
    }
	public int getPoints()
	{ return this.points; }
}