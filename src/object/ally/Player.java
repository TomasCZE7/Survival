package object.ally;

import object.template.MovingObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends MovingObject {

    public Player(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    public Player(double x, double y, Color color, Dimension size) {
        super(x, y, color, size);
    }

    public Player(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
    }

    public Player(double x, double y, Color color, Dimension size, boolean fill) {
        super(x, y, color, size, fill);
    }

    @Override
    public Shape getShape(Graphics2D g) {
        return new Rectangle2D.Double(getX(), getY(), getHeight(), getWidth());
    }

}
