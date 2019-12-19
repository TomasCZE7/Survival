package object.environment;

import core.component.shape.CustomShape;
import core.component.shape.RectangleShape;
import object.DimensionalObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Wall extends DimensionalObject {

    public Wall(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    @Override
    public CustomShape getCustomShape() {
        return new RectangleShape(getX(), getY(), getWidth(), getHeight(), getColor(), true);
    }
}
