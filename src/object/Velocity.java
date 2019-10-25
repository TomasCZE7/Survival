package object;

public abstract class Velocity extends Coordinates {

    private double xVelocity = 0, yVelocity = 0;

    public Velocity(double x, double y) {
        super(x, y);
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

}
