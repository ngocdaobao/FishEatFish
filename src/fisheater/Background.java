package fisheater;

import javax.swing.ImageIcon;

public class Background extends CoreObject
{
	private String icon = "fisheater/resources/background/background.jpg"; // image location
	
	public Background(int x, int y)
	{
		super(x,y);
                
                this.genImage(icon);
                
        }
}
