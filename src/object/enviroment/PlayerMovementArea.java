package object.enviroment;

import core.Core;
import object.template.DimensionalObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class PlayerMovementArea extends DimensionalObject {

    public PlayerMovementArea(double x, double y) {
        super(x, y, Color.RED, Core.WIDTH/3.0, Core.WIDTH/3.0);
    }

    @Override
    public Shape getShape(Graphics2D g) {
        return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
    }
}
