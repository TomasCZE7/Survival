package object.enviroment;

import object.template.DimensionalObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Wall extends DimensionalObject {

    public Wall(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    @Override
    public Shape getShape(Graphics2D g) {
        return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
    }
}
