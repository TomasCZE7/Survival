package object.environment;

import object.DimensionalObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Wall extends DimensionalObject {

    public Wall(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
    }
}
