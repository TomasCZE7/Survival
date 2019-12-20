package core.component.shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleShape extends EllipseShape {

    public CircleShape(double xPos, double yPos, double radius) {
        super(xPos, yPos, radius, radius);
    }

}
