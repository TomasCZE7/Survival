package object;

import core.GameMain;
import core.component.shape.CustomShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class GameObject implements Registrable {

    private double xVelocity = 0, yVelocity = 0;
    private double x, y;
    private double width, height;

    private Color color;
    private boolean fill;


    public GameObject(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK;
        this.fill = false;
        register();
    }

    public GameObject setColor(Color color) {
        this.color = color;
        return this;
    }

    public GameObject setFill(boolean fill) {
        this.fill = fill;
        return this;
    }

    public boolean isFill() {
        return fill;
    }

    public List<CustomShape> getAllShapes(){
        List<CustomShape> shapes = new ArrayList<>(Arrays.asList(getAdditionalShapes()));
        shapes.add(getCustomShape());
        return shapes;
    }

    public abstract CustomShape getCustomShape();

    public CustomShape[] getAdditionalShapes(){
        return new CustomShape[]{};
    }

    public void resetVelocity(){
        setXVelocity(0);
        setYVelocity(0);
    }

    public void teleport(double xDestination, double yDestination){
        setX(xDestination);
        setY(yDestination);
    }

    public void move(double x, double y){
        setX(getX() + x);
        setY(getY() + y);
    }

    public Point getCenter() {
        return new Point((int)(getX()+(getWidth() /2)),(int)(getY()+(getHeight()/2)));
    }

    public void render(Graphics2D g) {
        if(getAdditionalShapes().length > 0){
            for(CustomShape shape : getAdditionalShapes()){
                shape.draw(g);
            }
        }
        getCustomShape().draw(g);
    }

    @Override
    public void register() {
        GameMain.core.getObjectManager().addObject(this);
    }

    public void tick() {
        move(getXVelocity(), getYVelocity());
    }

    public void moveToward(Point target, double speed)
    {
        double xDiff = target.getX() - getCenter().getX();
        double yDiff = target.getY() - getCenter().getY();
        double dist = target.distance(getCenter());
        move(xDiff / dist * speed, yDiff / dist * speed);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVelocities(double xVelocity, double yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public double getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
