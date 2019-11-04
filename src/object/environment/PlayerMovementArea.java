package object.environment;

import core.Core;

public class PlayerMovementArea {

    private double x, y, width, height;

    public PlayerMovementArea() {
        x = Core.WIDTH/3.0;
        y = Core.HEIGHT/4.5;
        width = Core.WIDTH/3.0;
        height = Core.WIDTH/3.0;
    }

    public double getX() {
        return x;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getY() {
        return y;
    }
}
