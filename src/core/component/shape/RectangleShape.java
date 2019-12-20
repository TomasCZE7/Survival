package core.component.shape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleShape extends CustomShape {


    public RectangleShape(double xPos, double yPos, double width, double height) {
        super(xPos, yPos, width, height);
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getXPos(), getYPos(), getWidth(), getHeight());
    }

}
