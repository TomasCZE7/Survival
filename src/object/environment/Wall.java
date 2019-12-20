package object.environment;

import core.component.shape.CustomShape;
import core.component.shape.RectangleShape;
import object.GameObject;

import java.awt.*;

public class Wall extends GameObject {

    public Wall(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public CustomShape getCustomShape() {
        return new RectangleShape(getX(), getY(), getWidth(), getHeight()).setColor(getColor()).setFilled(isFill());
    }
}
