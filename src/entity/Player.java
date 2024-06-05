package entity;

import java.awt.event.KeyEvent;

public class Player extends Entity {
    private int speed;
    private String icon = "resources/fish/smallPlayer"; //update hinh anh playerfish o day

    public void setIcon(String newicon){
        this.icon = newicon;
    }
    private boolean speedUp = false,
            sharkEat = false;


    private int level;
    public int getLevel(){
        return this.level;
    }

    public void setlevel(int playerlevel){
        this.level = playerlevel;
    }

    public Player(int x, int y, int playerSpeed, int level) // constructor
    {
        super(x, y);
        String temp = "";

        temp = icon + "R" + ".png"; // khởi tạo mặc định cho player quay sang phải
        this.genImage(temp);

        this.center = new Center();

        this.speed = playerSpeed;

        this.level = level;
    }

    public void setSpeed(int s) {
        speed = s;
    }

    // get/set cho các thuộc tính speedUp và SharkEat
    public void setSpeedUp(boolean b) {
        speedUp = b;
    }

    public void setSharkEat(boolean b) {
        sharkEat = b;
    }

    public boolean getSharkEat() {
        return this.sharkEat;
    }

    public boolean getSpeedUp() {
        return this.speedUp;
    }

    public void move() {
        super.move(); // gọi đến phương thức move của lớp Entity

        // nếu flag SpeedUp = true thì gấp đôi vận tốc
        if (this.dx > 0 && this.speedUp)
            this.dx = 2 * speed;
        else if (this.dx < 0 && this.speedUp)
            this.dx = -2 * speed;
        if (this.dy > 0 && this.speedUp)
            this.dy = 2 * speed;
        else if (this.dy < 0 && this.speedUp)
            this.dy = -2 * speed;

        // điều kiện biên, đảm bảm player không chạy ra khỏi màn hình hiển thị trò chơi

        // nếu tọa độ x nhỏ hơn 1
        if (this.x < 1) {
            this.x = 1; // thì đặt nó bằng 1
            this.center.centerX = 1 + this.center.getCTEX(); // điều chỉnh lại centerX
        }
        if (this.x > (1280 - this.width * 2))
        // nếu tọa độ x chạy vượt quá giới hạn về bên phải
        // nhân 2 để đảm bảo va chạm với các con cá khác khi chúng ở mép
        {
            this.x = (1280 - this.width * 2); // đặt nó bằng giới hạn bên phải
            this.center.centerX = this.x + this.center.getCTEX(); // điều chỉnh lại centerX

        }

        // tương tự cho tọa độ Y
        if (this.y < 1) {
            this.y = 1;
            this.center.centerY = 1 + this.center.getCTEY();
        }
        if (this.y > (720 - this.height * 2)) {
            this.y = (720 - this.height * 2);
            this.center.centerY = this.y + this.center.getCTEY();
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        String temp = "";

        if (key == KeyEvent.VK_Q) {
            System.exit(0);
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (key == KeyEvent.VK_A) {
            this.dx = -this.speed;
            temp = icon + "L" + ".png";
            this.genImage(temp);
        }
        if (key == KeyEvent.VK_LEFT) {
            this.dx = -this.speed;
            temp = icon + "L" + ".png";
            this.genImage(temp);
        }

        if (key == KeyEvent.VK_D) {
            this.dx = this.speed;
            temp = icon + "R" + ".png";
            this.genImage(temp);
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.dx = this.speed;
            temp = icon + "R" + ".png";
            this.genImage(temp);
        }

        if (key == KeyEvent.VK_W) {
            this.dy = -this.speed;
        }
        if (key == KeyEvent.VK_UP) {
            this.dy = -this.speed;
        }

        if (key == KeyEvent.VK_S) {
            this.dy = this.speed;
        }
        if (key == KeyEvent.VK_DOWN) {
            this.dy = this.speed;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            this.dx = 0;
        }
        if (key == KeyEvent.VK_LEFT) {
            this.dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            this.dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            this.dy = 0;
        }
        if (key == KeyEvent.VK_UP) {
            this.dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            this.dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            this.dy = 0;
        }
    }
}
