package fisheater;

import java.util.Random;

public class Fish extends CoreObject
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
        int threshold = 15;

        //update hinh anh cac loai ca
        // extra small 15%
        if (random < threshold) {
            points = 1;
            icon = "fisheater/resources/fish/mpurplefish";
            level = 0;
        } // small 25%
        else if (threshold <= random && random < threshold + 25) {
            points = 5;
            icon = "fisheater/resources/fish/nemo";
            level = 1;
        } // medium 20%
        else if (threshold + 25 <= random && random < threshold + 45) {
            points = 10;
            icon = "fisheater/resources/fish/brownfish";
            level = 2;
        } // large 20%
        else if (threshold + 45 <= random && random < threshold + 65) {
            points = 15;
            icon = "fisheater/resources/fish/dory";
            level = 3;
        } // extra large 15%
        else if (threshold + 65 <= random && random < threshold + 80) {
            points = 25;
            icon = "fisheater/resources/fish/catim";
            level = 4;
        } // rare fish 5%
        else if (threshold + 80 <= random && random < threshold + 85) {
            points = 50;
            icon = "fisheater/resources/fish/canau";
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
