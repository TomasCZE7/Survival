package core.component.shape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleShape extends EllipseShape {

    public CircleShape(double xPos, double yPos, double width, Color color, boolean filled) {
        super(xPos, yPos, width, width, color, filled);
    }

    public CircleShape(double xPos, double yPos, double width, Color color) {
        this(xPos, yPos, width, color, false);
    }

    public CircleShape(double xPos, double yPos, double width) {
        this(xPos, yPos, width, Color.BLACK);
    }

    public CircleShape(double xPos, double yPos, double width, boolean filled) {
        this(xPos, yPos, width, Color.BLACK, filled);
    }
    
}
