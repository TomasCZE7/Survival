package object.environment;

import core.Core;
import core.GameMain;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PlayerMovementArea {

    private double x, y, width, height;

    public PlayerMovementArea() {
        x = GameMain.core.getSettings().getWidth()/3.0;
        y =  GameMain.core.getSettings().getHeight()/4.5;
        width =  GameMain.core.getSettings().getWidth()/3.0;
        height =  GameMain.core.getSettings().getWidth()/3.0;
    }

    public Shape getShape(){
        return new Rectangle2D.Double(x, y, width, height);
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
