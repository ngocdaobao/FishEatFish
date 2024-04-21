package fisheater;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class CoreObject 
{
	public int x,y, move_x, move_y; // x, y: tọa độ của  object; move_x, move_y: khoảng cách di chuyển của obj
	public int width, height;       // chiều rộng, chiều cao của object
	public Image img;
	public String path; // path file ảnh
	public boolean visible;
	public center ctr;  
	
	public class center {
		int center_x, center_y;  // tọa độ của center
		int r_x, r_y;            // Bán kính từ tâm tới các trục x, y
		
		public center() {
			r_x = width/2;
			r_y = height/2;
			center_x = x + r_x ;
			center_y = y + r_y;
		}

		public int get_x() {
			return this.center_x;
		}

		public int get_y() {
			return this.center_y;
		}

		public int get_r_x() {
			return this.r_x;
		}

		public int get_r_y() {
			return this.r_y;
		}
		
	}
	
	//Khởi tạo cho Obj
	public CoreObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.visible = true;
	}
	
	//Thay đổi vị trí
	public void switch_position() {
		this.x = this.x + this.move_x;
		this.y = this.y + this.move_y;
		this.ctr.center_x = this.ctr.center_x + this.move_x;
		this.ctr.center_y = this.ctr.center_y + this.move_y;
	}

	public int get_x() {
		return this.x;
	}

	public int get_y() {
		return this.y;
	}
	
	public int get_width() {
		return this.width;
	}
	
	public int get_height() {
		return this.height;
	}

	public void setVisible(boolean c) {
		this.visible = c;
	}

	public boolean checkVisible() {
                return this.visible;
	}

	public Image get_im() {
		return this.img;
	}

	// Import giao diện của Obj
	public void importImg(String path) {
		ImageIcon im = new ImageIcon(getClass().getClassLoader().getResource(path.toString()));
		this.img = im.getImage();
		this.width = im.getIconWidth();
		this.height= im.getIconHeight();
	}
	
	public void showImg(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
	}
	
	public void CheckVisible(boolean c) {
		this.visible = c;
	}
	
	public void paint(Graphics g)
	    {
	        if(this.visible)
	        {
	            g.drawImage(this.img, this.x, this.y, null);
	        }
	    }
	
	// Check 2 Objs có va chạm không
	public boolean CheckCollision(CoreObject enemy) {
		
		double limit_X = this.ctr.r_x + enemy.ctr.r_x;
		double distance_X = Math.abs(this.ctr.center_x - enemy.ctr.center_y);
		
		double limit_Y = this.ctr.r_y + enemy.ctr.r_y;
		double distance_Y = Math.abs(this.ctr.center_y - enemy.ctr.center_y);
		
		if ((distance_X <= limit_X) && (distance_Y<=limit_Y)) {
			return true;
		}
		return false;	
	}	
}
