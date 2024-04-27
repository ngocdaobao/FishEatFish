package fisheater;

import java.awt.Rectangle;

public class Shark extends CoreObject
{
	private String icon = "fisheater/resources/fish/Shark";
	private int points = 100;
	
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