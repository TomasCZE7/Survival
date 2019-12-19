package object.entity.ai;

import core.component.shape.CustomShape;
import core.component.shape.RectangleShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BasicZombie extends AI {

    public BasicZombie(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    @Override
    public CustomShape getCustomShape() {
        return new RectangleShape(getX(), getY(), getWidth(), getHeight(), getColor(), true);
    }

    @Override
    public double getDamage() {
        return 2;
    }

    @Override
    public double getMaxHealth() {
        return 40;
    }
}
