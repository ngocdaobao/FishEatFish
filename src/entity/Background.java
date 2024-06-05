package entity;

import javax.swing.ImageIcon;

public class Background extends Entity
{
	private String icon = "resources/background/background.png"; // image location
	
	public Background(int x, int y)
	{
		super(x,y);
                
                this.genImage(icon);
                
        }
}
