package fisheater;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class CoreObject 
{
	protected int x, y, dx, dy;
	protected int width, height;
	protected Image image;
	protected boolean visible;
    protected String location;
    protected Center center;
	
    public CoreObject(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.visible = true;
    }
	
	public void genImage(String location)
	{
		ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(location.toString()));
		this.image = ii.getImage();
		this.width = ii.getIconWidth();
		this.height= ii.getIconHeight();
                
	}
	
	public void move()
	{
		this.x += this.dx;
		this.y += this.dy;
                this.center.centerX += this.dx;
                this.center.centerY += this.dy;
	}
	
	public void setVisible(boolean v)
	{ visible = v; }
	
	public boolean isVisible()
	{ return visible; }
	
	public int getX()
	{ return x; }
	
	public int getY()
	{ return y; }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }
	
	public Image getImage()
	{ return image; }
    
    public void paint(Graphics g)
    {
        if(this.visible)
        {
            g.drawImage(this.image, this.x, this.y, null);
        }
    }
    
    public boolean EllipseCollision(CoreObject enemy)
    {
    	
		double  limit_X = this.center.CTEX + enemy.center.CTEX;
		double distance_X = Math.abs(this.center.centerX - enemy.center.centerX);
		
		double limit_Y = this.center.CTEY + enemy.center.CTEY;
		double distance_Y = Math.abs(this.center.centerY - enemy.center.centerY);
		
		if ((distance_X <= limit_X) && (distance_Y<=limit_Y)) {
			return true;
		}
		return false;	
    }
    protected class Center
    {
        protected double centerX, centerY;
        private double CTEX, CTEY; // center-to-Edge X and Y
        
        public Center()
        {
            CTEX = width / 2;
            CTEY = height / 2;
            centerX = x + CTEX;
            centerY = y + CTEY;
        }
        
        public double getX()
        {
            return centerX;
        }
        
        public double getY()
        {
            return centerY;
        }
        
        public double getCTEX()
        {
            return CTEX;
        }
        
        public double getCTEY()
        {
            return CTEY;
        }
    }
        
} 



