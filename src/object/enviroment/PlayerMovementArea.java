package object.enviroment;

import core.Core;
import object.template.DimensionalObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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
