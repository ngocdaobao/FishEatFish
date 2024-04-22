package fisheater;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class CoreObject 
{
	protected int x, y;				//Tọa độ object
	protected int  dx, dy;			//Bước di chuyển của object
	protected int width, height;	// chiều rộng, chiều cao của object
	protected Image image;
	protected boolean visible;
	protected String location;		// path file ảnh
	protected Center center;
	
	//Khởi tạo cho Obj
	public CoreObject(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.visible = true;
	}
	
	// Import giao diện của Obj
	public void genImage(String location)
	{
		ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource(location.toString()));
		this.image = ii.getImage();
		this.width = ii.getIconWidth();
		this.height= ii.getIconHeight();
				
	}
	
	//Thay đổi vị trí
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
	
	// Check 2 Objs có va chạm không
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
		protected double centerX, centerY;	// tọa độ của center
		private double CTEX, CTEY; 			// Bán kính từ tâm tới các trục x, y
		
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



