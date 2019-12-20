package core.component.shape;

import java.awt.*;
import java.awt.geom.Line2D;

public class LineShape extends CustomShape {

    public LineShape(double xPos, double yPos, double width, double height) {
        super(xPos, yPos, width, height);
    }

    @Override
    public Shape getShape() {
        return new Line2D.Double(getPositionPoint(), getSizePoint());
    }

}
