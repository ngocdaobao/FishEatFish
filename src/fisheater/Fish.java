package fisheater;

public class Fish extends CoreObject 
{
	private int points = 25;
	private String icon = "fisheater/resources/fish/smallfish";
	
	public Fish(int x, int y, int speed, String direction)
	{
		super(x,y);
		
        icon += direction + ".png";
		this.genImage(icon);
		
                this.center = new Center();
		this.dy = 0;
		this.dx = -speed;
	}
	
	public int getPoints()
	{ return this.points; }
        
    public int getSpeed()
    {
        return dx;
    }
}
