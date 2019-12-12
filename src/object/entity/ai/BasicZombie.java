package object.entity.ai;

import object.entity.Damage;
import object.entity.Entity;
import object.entity.Health;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class BasicZombie extends AI implements Health, Damage {

    public BasicZombie(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
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
