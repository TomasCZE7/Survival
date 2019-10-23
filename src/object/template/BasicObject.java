package object.template;

import core.GameMain;

import java.awt.*;

public abstract class BasicObject implements Registrable {

    private double x, y;

    public BasicObject(double x, double y){
        this.x = x;
        this.y = y;
        register();
    }

    @Override
    public void register() {
        GameMain.core.getObjectManager().addBasicObject(this);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void teleport(double xDestination, double yDestination){
        setX(xDestination);
        setY(yDestination);
    }

    public void move(double x, double y){
        setX(getX() + x);
        setY(getY() + y);
    }
}
