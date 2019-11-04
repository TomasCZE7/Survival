package object.entity.ai;

import object.entity.Entity;

import java.awt.*;

public abstract class AI extends Entity {


    public AI(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    public AI(double x, double y, Color color, Dimension size) {
        super(x, y, color, size);
    }

    public AI(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
    }

    public AI(double x, double y, Color color, Dimension size, boolean fill) {
        super(x, y, color, size, fill);
    }
}
