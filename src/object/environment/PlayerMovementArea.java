package object.environment;

import core.Core;
import core.GameMain;
import core.component.shape.CustomShape;
import core.component.shape.RectangleShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PlayerMovementArea {

    private double x, y, width, height;

    public PlayerMovementArea() {
        width =  GameMain.core.getSettings().getWidth()/3.0;
        height =  GameMain.core.getSettings().getWidth()/3.0;
        x = GameMain.core.getSettings().getWidth()/3.0-width/2;
        y =  GameMain.core.getSettings().getHeight()/3.0-width/3.0;
    }

    public CustomShape getCustomShape(){
        return new RectangleShape(x, y, width, height).setColor(Color.RED);
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
