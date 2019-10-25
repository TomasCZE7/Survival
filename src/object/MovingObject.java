package object;

import core.GameMain;

import java.awt.*;

public abstract class MovingObject extends DimensionalObject {

    public MovingObject(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    public MovingObject(double x, double y, Color color, Dimension size) {
        super(x, y, color, size);
    }


    public MovingObject(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
    }

    public MovingObject(double x, double y, Color color, Dimension size, boolean fill) {
        super(x, y, color, size, fill);
    }

    @Override
    public void register() {
        GameMain.core.getObjectManager().addMovingObject(this);
    }

    @Override
    public Shape getShape(Graphics2D g) {
        return null;
    }

    @Override
    public void tick() {
        move(getXVelocity(), getYVelocity());
    }
}
