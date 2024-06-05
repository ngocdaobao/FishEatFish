package entity;
import java.util.Random;

// player getSharkEat

public class EatShark extends Entity {

    private long duration; //luu tham so cho thoi gian của PowerUp

    private String name; //luu ten cua powerup
    private String icon = "resources/fish/star.png"; //path dan den file luu icon cho object powerup

    private int counter = 0; //theo doi thoi gian con lai cua powerup

    private boolean isAlive = false; // kiem tra xem powerup con hieu luc hay khong

    public EatShark(int x, int y, int speed) //constructor của PowerUp, nhận x, y là tọa độ rơi, speed là vận tốc rơi
    {
        super(x,y);

        this.genImage(icon);

        this.dx = 0; // mặc định vận tốc theo phương x = 0 để PowerUp rơi thẳng đứng
        this.dy = speed;
        this.name = "Shark Eat";
        this.counter = 0;
        this.isAlive = true; // mặc định PowerUp là active

        this.center = new Center(); // gọi đến constructor của center trong coreobject

        genEatShark(); // gọi phương thức genPower để khởi tạo, xem method này ở dưới
    }

    public void move()
    {
        super.move();

        if(this.y > 600) //nếu PowerUp chạy ra khỏi màn hình trò chơi
        {
            this.isAlive = false; // không active, không hiển thị trên màn hình
        }
    }

   public void genEatShark()
    {

        counter = 63*14;
        
    }
   
    // khi người chơi chạm vào PowerUp thì nó bien mat khoi man hinh
    //sau khoang thoi gian counter thì mới xuất hiện trở lại
    public void setY(int y)
    {
        this.y = y;
        this.dy = 0;
    }

    public void setAlive(boolean b)
    {
        this.isAlive = b;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean isAlive()
    {
        return this.isAlive;
    }

    public int getDuration()
    {
        counter--;
        return counter;
    }
}


