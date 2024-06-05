package entity;

import java.util.Random;

public class Fish extends Entity
{
    private int points;
    private String icon;
    private int level;

    public int getLevel(){
        return this.level;
    }

    public Fish(int x, int y, int speed, String direction, int fishlevel) {
        super(x, y);
        int random = new Random().nextInt(100);

        //update hinh anh cac loai ca
        // extra small 15%
        if (random < 10) {
            points = 1;
            icon = "resources/fish/XSfish1";
            level = 0;
        } else if (10 <= random && random < 20) {
            points = 1;
            icon = "resources/fish/XSfish2";
            level = 0;
        } // small 25%
        else if (20 <= random && random < 25) {
            points = 2;
            icon = "resources/fish/Sfish1";
            level = 1;
        } else if (25 <= random && random <= 40) {
            points = 2;
            icon = "resources/fish/Sfish2";
            level = 1;
        }  // medium 20%
        else if (40 <= random && random < 60) {
            points = 5;
            icon = "resources/fish/Mhorsefish";
            level = 2;
        } // large 20%
        else if (60 <= random && random < 70) {
            points = 10;
            icon = "resources/fish/Lfish1";
            level = 3;
        } else if (70 <= random && random < 80) {
            points = 10;
            icon = "resources/fish/Lfish2";
            level = 3;
        }
        // extra large 15%
        else if (80 <= random && random < 90) {
            points = 15;
            icon = "resources/fish/XLfish1";
            level = 4;
        } else if (90 <= random && random < 95) {
            points = 15;
            icon = "resources/fish/XLfish2";
            level = 4;
        } // rare fish 5%
        else if (95 <= random && random < 97) {
            points = 25;
            icon = "resources/fish/beta";
            level = 5;
        }
        else {
            points = 25;
            icon = "resources/fish/zebra";
            level = 5;

        }

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
