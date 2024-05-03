package fisheater;

import java.util.Random;

public class Fish extends CoreObject
{
    private int points;
    private String icon;
    public Fish(int x, int y, int speed, String direction) {
        super(x, y);
        int random = new Random().nextInt(100);
        int threshold = 15;
        // extra small 15%
        if (random < threshold) {
            points = 1;
            icon = "fisheater/resources/fish/fish";
        } // small 25%
        else if (threshold <= random && random < threshold + 25) {
            points = 5;
            icon = "fisheater/resources/fish/fish2";
        } // medium 20%
        else if (threshold + 25 <= random && random < threshold + 45) {
            points = 10;
            icon = "fisheater/resources/fish/fish3";
        } // large 20%
        else if (threshold + 45 <= random && random < threshold + 65) {
            points = 15;
            icon = "fisheater/resources/fish/fish4";
        } // extra large 15%
        else if (threshold + 65 <= random && random < threshold + 80) {
            points = 25;
            icon = "fisheater/resources/fish/catim";
        } // rare fish 5%
        else if (threshold + 80 <= random && random < threshold + 85) {
            points = 50;
            icon = "fisheater/resources/fish/canau";
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
