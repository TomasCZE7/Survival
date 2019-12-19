package core.component.shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipseShape extends CustomShape{

    public EllipseShape(double xPos, double yPos, double width, double height, Color color, boolean filled) {
        super(xPos, yPos, width, height, color, filled);
    }

    public EllipseShape(double xPos, double yPos, double width, double height, Color color) {
        super(xPos, yPos, width, height, color);
    }

    public EllipseShape(double xPos, double yPos, double width, double height) {
        super(xPos, yPos, width, height);
    }

    public EllipseShape(double xPos, double yPos, double width, double height, boolean filled) {
        super(xPos, yPos, width, height, filled);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getXPos(), getYPos(), getWidth(), getHeight());
    }
}
