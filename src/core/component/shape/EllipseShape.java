package core.component.shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipseShape extends CustomShape{

    public EllipseShape(double xPos, double yPos, double width, double height) {
        super(xPos, yPos, width, height);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getXPos(), getYPos(), getWidth(), getHeight());
    }
}
